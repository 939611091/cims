package com.cims.controller.teacher;

import com.cims.dao.Attendance_statusMapper;
import com.cims.entity.Attendance;
import com.cims.entity.Attendance_status;
import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.ApplyService;
import com.cims.service.AttendanceService;
import com.cims.service.TeacherService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.AttendanceDetailsVo;
import com.cims.vo.AttendanceVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher/attendance")
public class TAttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Attendance_statusMapper attendance_statusMapper;
    @Autowired
    private ApplyService applyService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/teacher/login";
        }
        //根据老师登录后的session信息获取老师ID，只查看自己负责的请假信息
        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        List<AttendanceDetailsVo> attendanceDetailsVoList = attendanceService.selectByTeacherId(teacherId);
        model.addAttribute("attendanceDetailsVoList",attendanceDetailsVoList);
        return "manager/teacher/attendance_list";
    }
//    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
//    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
//                       @RequestParam(required = false, defaultValue = "10") int pageSize,
//                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
//                       Map<String, Object> map) {
//        if (session.getAttribute("teacher")==null){
//            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
//            return "redirect:/teacher/login";
//        }
//        PageInfo<AttendanceVo> pageResult = attendanceService.selectByMap(params, pageNum, pageSize);
//        map.put("pageResult", pageResult);
//        map.put("params", params);
//        return "manager/teacher/attendance_list";
//    }
//
//    @RequestMapping(value = "/applyList", method = {RequestMethod.GET, RequestMethod.POST})
//    public String list(Integer id, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
//        if (session.getAttribute("teacher")==null){
//            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
//            return "redirect:/teacher/login";
//        }
//        List<Apply_payVo> apply_payVoList = teacherService.selectByCourseId(id);
//        model.addAttribute("apply_payVoList",apply_payVoList);
//        List<Attendance_status> attendance_statusList = attendance_statusMapper.selectAll();
//        model.addAttribute("attendance_statusList",attendance_statusList);
//        return "manager/teacher/attendance_applyList";
//    }

    /**
     * 考勤按钮
     * 传courseId过来，然后更新这个courseId的apply
     * 剩余课时-课程每次上课的课时
     * 返回考勤成功
     */
    @RequestMapping(value = "/update.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(Integer id,Integer cPeriod, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        applyService.updateSurplusHourByCourseId(id,cPeriod);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：考勤成功");
        return "redirect:/teacher/course/myList";
    }

    /**
     * 判断你是否有权限
     * 批准把状态调成1
     * @param id
     * @param redirectAttributes
     * @param session
     * @return
     */
    @RequestMapping(value = "/updateState1.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String  updateTeacherState1(Integer id,RedirectAttributes redirectAttributes, HttpSession session ){
        Attendance attendance = attendanceService.selectByPrimaryKey(id);
        //只能编辑自己的课程
        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        if(attendance.getTeacherId() != teacherId){
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：你只能批准你负责的请假信息");
            return "redirect:/teacher/attendance/list";
        }
        attendanceService.updateTeacherState1ById(id);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：已批准");
        return "redirect:/teacher/attendance/list";
    }


    @RequestMapping(value = "/updateState2.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String  updateTeacherState2(Integer id,RedirectAttributes redirectAttributes, HttpSession session ){
        Attendance attendance = attendanceService.selectByPrimaryKey(id);
        //只能编辑自己的课程
        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        if(attendance.getTeacherId() != teacherId){
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：你只能批准你负责的请假信息");
            return "redirect:/teacher/attendance/list";
        }
        attendanceService.updateTeacherState2ById(id);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：不批准");
        return "redirect:/teacher/attendance/list";
    }

    /**
     * 更新这个请假单确认学生是否到课
     * 未到课把状态调成1
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/updateStudentState1.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String  updateStudentState1(Integer id,RedirectAttributes redirectAttributes ){
        attendanceService.updateStudentState1ById(id);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：已成功操作学生未到课");
        return "redirect:/teacher/attendance/list";
    }

    /**
     * 更新这个请假单确认学生是否到课
     * 到课把状态调成2
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/updateStudentState2.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String  updateStudentState2(Integer id,RedirectAttributes redirectAttributes ){
        attendanceService.updateStudentState2ById(id);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：已成功操作学生到课");
        return "redirect:/teacher/attendance/list";
    }
}

package com.cims.controller.student;

import com.cims.dao.Attendance_statusMapper;
import com.cims.entity.*;
import com.cims.service.*;
import com.cims.vo.AttendanceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student/attendance")
public class SAttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Attendance_statusMapper attendance_statusMapper;
    @Autowired
    private ApplyService applyService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private AStudentService aStudentService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("student") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/student/login";
        }
        Integer studentId=((Student)session.getAttribute("student")).getstudentId();
        List<AttendanceVo> attendanceVoList = attendanceService.selectByStudentId(studentId);
        model.addAttribute("attendanceVoList",attendanceVoList);
        return "manager/student/attendance_list";
    }
    /**
     * 填写对应课程的请假条
     *
     * @author vanh
     * @date 2019/8/1
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/add")
    public String add(Integer id, Map<String, Object> map, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("student") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/student/login";
        }
        /**
         *传过来的是报名缴费ID，直接获取
         *用报名缴费ID得到课程ID
         *通过课程查到老师ID
         */
        Apply_pay apply_pay = applyService.selectByPrimaryKey(id);
        Integer courseId = apply_pay.getCourseId();
        map.put("apply_pay",apply_pay);
        Course course = courseService.selectByPrimaryKey(courseId);
        map.put("course",course);
        List<Attendance_status> attendance_statusList = attendance_statusMapper.selectAll();
        map.put("attendance_statusList",attendance_statusList);
        return "manager/student/attendance_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/29
     */
    @PostMapping("/add.do")
    public String addA(Attendance attendance, RedirectAttributes redirectAttributes) {

        //默认为0表示未批准未处理
        attendance.setState(0);
        attendance.setTeacherState(0);
        attendance.setStudentState(0);
        //存储数据
        if(attendanceService.insert(attendance)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：申请成功");
            return "redirect:/student/attendance/list";
        }else {
            redirectAttributes.addFlashAttribute("msgError","失败提示：申请失败");
            return "redirect:/student/attendance/list";
        }
    }


    /**
     * 删除
     * @author vanh
     * @date 2019/8/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        attendanceService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：取消成功");
        return "redirect:/student/attendance/list";
    }
}

package com.cims.controller.teacher;

import com.cims.dao.Attendance_statusMapper;
import com.cims.entity.Apply_pay;
import com.cims.entity.Attendance;
import com.cims.entity.Attendance_status;
import com.cims.service.AttendanceService;
import com.cims.service.TeacherService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.AttendanceVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Attendance_statusMapper attendance_statusMapper;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        PageInfo<AttendanceVo> pageResult = attendanceService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/teacher/attendance_list";
    }

    @RequestMapping(value = "/applyList", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Integer id, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        List<Apply_payVo> apply_payVoList = teacherService.selectByCourseId(id);
        model.addAttribute("apply_payVoList",apply_payVoList);
        List<Attendance_status> attendance_statusList = attendance_statusMapper.selectAll();
        model.addAttribute("attendance_statusList",attendance_statusList);
        return "manager/teacher/attendance_applyList";
    }


}

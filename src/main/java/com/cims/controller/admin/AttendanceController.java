package com.cims.controller.admin;

import com.cims.entity.Attendance;
import com.cims.entity.Teacher;
import com.cims.service.AttendanceService;
import com.cims.vo.AttendanceVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        PageInfo<AttendanceVo> pageResult = attendanceService.selectByMap2(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/attendance_list";
    }

    @RequestMapping(value = "/updateState.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String  updateTeacherState(Integer id,RedirectAttributes redirectAttributes, HttpSession session ){
        attendanceService.updateStateById(id);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：已退费");
        return "redirect:/admin/attendance/list";
    }
}

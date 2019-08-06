package com.cims.controller.admin;

import com.cims.entity.Attendance_status;
import com.cims.entity.Course_category;
import com.cims.service.AttendanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/attendanceStatus")
public class AttendanceStatusController {

    @Autowired
    private AttendanceStatusService attendanceStatusService;

    /**
     * 列表界面
     *
     * @return mv
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/list")
    public String selectAll(Model model, RedirectAttributes redirectAttributes, HttpSession session){
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        List<Attendance_status> list = attendanceStatusService.selectAll();
        model.addAttribute("attendanceStatusList",list);
        return "manager/admin/attendanceStatus_list";
    }


    /**
     * 添加界面
     *
     * @return jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/add")
    public String add(RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/attendanceStatus_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/add.do")
    public String add(Attendance_status attendance_status, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (attendance_status.getStatus().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：状态名不能为空！");
            return "redirect:/admin/attendanceStatus/add";
        }

        attendanceStatusService.insert(attendance_status);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
        return "redirect:/admin/attendanceStatus/list";
    }

    /**
     * 修改页面
     *
     * @author vanh
     * @date 2019/7/20
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/edit")
    public String editStatus(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Attendance_status attendance_status = attendanceStatusService.selectByPrimaryKey(id);

        map.put("attendance_status",attendance_status);

        return "manager/admin/attendanceStatus_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/edit.do")
    public String edit(Attendance_status attendance_status, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (attendance_status.getStatus().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：状态名不能为空！");
            return "redirect:/admin/attendanceStatus/edit";
        }
        if(attendanceStatusService.updateByPrimaryKey(attendance_status)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }

        return "redirect:/admin/attendanceStatus/list";
    }

    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        attendanceStatusService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/attendanceStatus/list";
    }
}

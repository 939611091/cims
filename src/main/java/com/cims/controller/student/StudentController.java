package com.cims.controller.student;

import com.cims.service.ApplyService;
import com.cims.service.StudentService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.HonorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student/course")
public class StudentController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private StudentService studentService;
    //查出这个学生ID对应的报名单列出来
    @RequestMapping("/list")
    public String index(Integer id,Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("student")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/student/login";
        }
        List<Apply_payVo> applyVoList = studentService.selectByStudentId(id);
        model.addAttribute("applyVoList",applyVoList);
        return "manager/student/apply_list";
    }
}

package com.cims.controller.student;

import com.cims.entity.Course;
import com.cims.service.ApplyService;
import com.cims.service.CourseService;
import com.cims.service.StudentService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseDetailsVo;
import com.cims.vo.CourseVo;
import com.cims.vo.HonorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student/course")
public class StudentController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
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

    /**
     * 前端模态框数据
     */
    @PostMapping("/modeDate")
    @ResponseBody
    public CourseDetailsVo modeDate(HttpServletRequest request)  {
        //id是课程ID
        Integer id = Integer.parseInt(request.getParameter("id"));
        //根据课程ID查课程详情
        CourseDetailsVo course = courseService.selectById(id);

        return course;
    }
}

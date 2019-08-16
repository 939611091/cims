package com.cims.controller.home;

import com.cims.entity.Teacher;
import com.cims.service.ATeacherService;
import com.cims.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home/teacher")
public class HTeacherController {
    @Autowired
    private ATeacherService aTeacherService;
    @RequestMapping("/index")
    public String index(Model model) {
        //查出所有老师
        List<Teacher> teacherList = aTeacherService.selectAll();
        model.addAttribute("teacherList",teacherList);
        return "home/teacher_index";
    }
}

package com.cims.controller.home;

import com.cims.entity.Course_category;
import com.cims.service.CourseCategoryService;
import com.cims.service.CourseService;
import com.cims.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = {"/home/course", "/course"})
public class HCourseController {
    @Autowired
    private CourseCategoryService courseCategoryService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/index")
    public String index(Model model) {
        //查出所有课程类别
        List<Course_category> list = courseCategoryService.selectAll();
        model.addAttribute("categoryList",list);
        //查出最新发布的6个课程
        List<CourseVo> courseVoList = courseService.selectCourseBySix();
        model.addAttribute("courseVoList",courseVoList);
        return "home/course_index";
    }
}

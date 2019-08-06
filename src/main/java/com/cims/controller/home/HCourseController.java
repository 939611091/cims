package com.cims.controller.home;

import com.cims.entity.Course_category;
import com.cims.service.CourseCategoryService;
import com.cims.service.CourseService;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/byCategory")
    public String byCategory(Integer id,Model model) {
        //查出所有课程类别
        List<Course_category> list = courseCategoryService.selectAll();
        model.addAttribute("categoryList",list);
        //根据传过来的课程类别ID查出类别名
        Course_category course_category = courseCategoryService.selectByPrimaryKey(id);
        model.addAttribute("course_category",course_category);
        //根据传过来的课程类别ID查出所有这个类别的课程;
        List<CourseVo> courseVoList = courseService.selectByCategoryId(id);
        model.addAttribute("courseVoList",courseVoList);
        return "home/course_byCategory";
    }

    /**
     * 通过关键词搜索
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/byKeyword")
    public String searchByKeyword(@RequestParam("keyword") String keyword,Map<String,Object> conditionMap,
                                         @RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         Map<String,Object> model){
        //查出所有课程类别
        List<Course_category> list = courseCategoryService.selectAll();
        model.put("categoryList",list);
        conditionMap.put("keyword",keyword);
        PageInfo<CourseVo> courseVoPageInfo = courseService.selectByMap(conditionMap,pageNum,pageSize);
        model.put("courseVoList",courseVoPageInfo);
        model.put("keyword",keyword);
        return "home/course_byKeyword";
    }
}

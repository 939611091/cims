package com.cims.controller.home;

import com.cims.dao.HonorMapper;
import com.cims.entity.Teacher;
import com.cims.entity.User;
import com.cims.service.ATeacherService;
import com.cims.service.CourseService;
import com.cims.service.HonorService;
import com.cims.vo.CourseVo;
import com.cims.vo.HonorVo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = {"/home", "/"})
public class IndexController {
    @Autowired
    private ATeacherService aTeacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private HonorService honorService;

    @RequestMapping("/index")
    public String index(Model model) {
        //获取老师信息显示到前端
        List<Teacher> teacherList = aTeacherService.selectAll();
        model.addAttribute("teacherList",teacherList);

        //获取舞蹈课程到前端
        Integer danceId = 1;
        List<CourseVo> courseVoList1 = courseService.selectByCategoryId(danceId);
        model.addAttribute("courseVoList1",courseVoList1);
        //获取音乐课程到前端
        Integer musicId = 2;
        List<CourseVo> courseVoList2 = courseService.selectByCategoryId(musicId);
        model.addAttribute("courseVoList2",courseVoList2);
        //获取体育运动课程到前端
        Integer peId = 3;
        List<CourseVo> courseVoList3 = courseService.selectByCategoryId(peId);
        model.addAttribute("courseVoList3",courseVoList3);
        //获取其他兴趣课程到前端
        Integer otherId = 4;
        List<CourseVo> courseVoList4 = courseService.selectByCategoryId(otherId);
        model.addAttribute("courseVoList4",courseVoList4);

        //获取学生荣誉到前端
        List<HonorVo> honorVoList =honorService.selectAll();
        model.addAttribute("honorVoList",honorVoList);
        return "home/index";
    }


}

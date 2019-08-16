package com.cims.controller.home;

import com.cims.entity.Honor;
import com.cims.entity.Teacher;
import com.cims.service.HonorService;
import com.cims.vo.HonorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/studentHonor")
public class StudentHonorController {
    @Autowired
    private HonorService honorService;
    @RequestMapping("/index")
    public String index(Model model) {
        //获取学生荣誉到前端
        List<HonorVo> honorVoList =honorService.selectAll();
        model.addAttribute("honorVoList",honorVoList);
        return "home/studentHonor_index";
    }
}

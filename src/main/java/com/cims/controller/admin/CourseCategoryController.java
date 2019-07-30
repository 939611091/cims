package com.cims.controller.admin;


import com.cims.entity.Course_category;
import com.cims.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/courseCategory")
public class CourseCategoryController {
    @Autowired
    private CourseCategoryService courseCategoryService;

    /**
     * 列表界面
     *
     * @return mv
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/list")
    public ModelAndView selectAll(){
        ModelAndView mv = new ModelAndView();
        List<Course_category> list = courseCategoryService.selectAll();
        mv.addObject("categoryList",list);
        mv.setViewName("manager/admin/courseCategory_list");
        return mv;
    }

    /**
     * 添加界面
     *
     * @return jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/add")
    public String add(RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/courseCategory_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/add.do")
    public String add(Course_category course_category, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (course_category.getcategoryName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：类别不能为空！");
            return "redirect:/admin/courseCategory/add";
        }

        courseCategoryService.insert(course_category);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
        return "redirect:/admin/courseCategory/list";
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
    public String editCategory(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Course_category course_category = courseCategoryService.selectByPrimaryKey(id);

        map.put("course_category",course_category);

        return "manager/admin/courseCategory_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/edit.do")
    public String edit(Course_category course_category, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (course_category.getcategoryName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程类别不能为空！");
            return "redirect:/admin/courseCategory/edit";
        }
        if(courseCategoryService.updateByPrimaryKey(course_category)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }

        return "redirect:/admin/courseCategory/list";
    }

    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        courseCategoryService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/courseCategory/list";
    }
}

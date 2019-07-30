package com.cims.controller.admin;

import com.cims.entity.Classroom;
import com.cims.service.ClassroomService;
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
@RequestMapping("/admin/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    /**
     * 列表界面
     *
     * @return mv
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/list")
    public ModelAndView getAllClassroom(){
        ModelAndView mv = new ModelAndView();
        List<Classroom> list = classroomService.getAllClassroom();
        mv.addObject("classroomList",list);
        mv.setViewName("manager/admin/classroom_list");
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
        return "manager/admin/classroom_add";
    }


    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/add.do")
    public String add(Classroom classroom, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (classroom.getClassroomName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：教室名不能为空！");
            return "redirect:/admin/classroom/add";
        }

        classroomService.insert(classroom);
        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
        return "redirect:/admin/classroom/list";
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
    public String editClassroom(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Classroom classroom = classroomService.selectByPrimaryKey(id);

        map.put("classroom",classroom);

        return "manager/admin/classroom_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/edit.do")
    public String edit(Classroom classroom, RedirectAttributes redirectAttributes) {
        //检查不能为空
        if (classroom.getClassroomName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：教室名不能为空！");
            return "redirect:/admin/classroom/edit";
        }
        if(classroomService.updateByPrimaryKey(classroom)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }

        return "redirect:/admin/classroom/list";
    }
    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        classroomService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/classroom/list";
    }
}

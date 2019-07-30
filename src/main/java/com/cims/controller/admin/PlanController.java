package com.cims.controller.admin;

import com.cims.entity.Classroom;
import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.entity.Course_classroom;
import com.cims.service.ClassroomService;
import com.cims.service.CourseService;
import com.cims.service.PlanService;
import com.cims.vo.CourseVo;
import com.cims.vo.Course_classroomVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/plan")
public class PlanController {
    @Autowired
    private PlanService planService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("admin") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/admin/login";
        }
        PageInfo<Course_classroomVo> pageResult = planService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);

        return "manager/admin/plan_list";
    }

    @GetMapping("/addHint")
    public String addHint(Map<String, Object> map, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/plan_hint";
    }

    @GetMapping("/addPlan")
    public String addPlan(Integer id, Map<String, Object> map, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/admin/login";
        }
        //查询这个课程是否安排了
        if(planService.selectByCourseId(id) > 0){
            redirectAttributes.addFlashAttribute("msgSuccess", "失败提示：该课程已安排，如需变更可以去编辑！");
            return "redirect:/admin/course/list";
        }else {
            Course course = courseService.selectByPrimaryKey(id);
            map.put("course", course);
            List<Classroom> classroomList = classroomService.getAllClassroom();
            map.put("classroomList", classroomList);
            return "manager/admin/plan_add";
        }

    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/addPlan.do")
    public String add(Course_classroom course_classroom, RedirectAttributes redirectAttributes) {

        if (planService.insert(course_classroom) > 0) {
            redirectAttributes.addFlashAttribute("msgSuccess", "成功提示：添加成功");

            return "redirect:/admin/plan/list";
        } else {
            redirectAttributes.addFlashAttribute("msgSuccess", "失败提示：添加失败");

            return "redirect:/admin/plan/list";
        }
    }

    /**
     * 跳转编辑页面
     *
     * @param id
     * @param map
     * @param redirectAttributes
     * @param session
     * @return
     */
    @GetMapping("/editPlan")
    public String editPlan(Integer id, Map<String, Object> map, RedirectAttributes redirectAttributes,
                           HttpSession session) {
        if (session.getAttribute("admin") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/admin/login";
        }
        Course_classroom course_classroom = planService.selectByPrimaryKey(id);
        map.put("course_classroom", course_classroom);
        List<Classroom> classroomList = classroomService.getAllClassroom();
        map.put("classroomList", classroomList);
        return "manager/admin/plan_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/29
     */
    @RequestMapping(value = "/editPlan.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String edit(Course_classroom course_classroom, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
        //存储数据
        if (planService.updateByPrimaryKey(course_classroom) > 0) {
            redirectAttributes.addFlashAttribute("msgSuccess", "成功提示：修改成功");
            return "redirect:/admin/plan/list";
        } else {
            redirectAttributes.addFlashAttribute("msgSuccess", "失败提示：修改失败");
            return "redirect:/admin/plan/list";
        }
    }
    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        planService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/plan/list";
    }
}
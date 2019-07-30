package com.cims.controller.admin;

import com.cims.entity.*;
import com.cims.service.AStudentService;
import com.cims.service.ApplyService;
import com.cims.service.CourseService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private AStudentService aStudentService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        PageInfo<Apply_payVo> pageResult = applyService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/apply_list";
    }

    /**
     * 添加报名缴费页面
     * 查出所有课程
     * @param map
     * @return jsp页面
     */
    @RequestMapping(value = "/addApply", method = {RequestMethod.GET, RequestMethod.POST})
    public String addApply(@RequestParam(required = false, defaultValue = "1") int pageNum,
                           @RequestParam(required = false, defaultValue = "10") int pageSize,
            @RequestParam Map<String, Object> params,Map<String, Object> map,RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        List<Course> courseList = courseService.selectAll();
        map.put("courseList", courseList);

        //用于查询学生ID
        PageInfo<Student> pageResult = aStudentService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/apply_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/29
     */
    @PostMapping("/addApply.do")
    public String add(Apply_pay apply_pay, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {

        //检查学生ID不能为空
        if (apply_pay.getStudentId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：学生ID不能为空！");
            return "redirect:/admin/apply/addApply";
        }
        //检查报名学生不能为空
        if (apply_pay.getPayStudent().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：报名学生不能为空！");
            return "redirect:/admin/apply/addApply";
        }
        //检查课程ID不能为空
        if (apply_pay.getCourseId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程ID不能为空！");
            return "redirect:/admin/apply/addApply";
        }
//        //检查报名课时不能为空
//        if (apply_pay.getHour() == null) {
//            redirectAttributes.addFlashAttribute("msgError", "错误提示：报名课时不能为空！");
//            return "redirect:/admin/apply/addApply";
//        }

        //判断课程剩余人数是否>0，大于则可以报名，否则则报名失败
        //获取报名的课程ID查到他的剩余学时
        Course course = courseService.selectByPrimaryKey(apply_pay.getCourseId());
        if(course.getSurplusNumber() > 0){
            //存储数据
            if(applyService.insert(apply_pay)>0){
                //报名成功后，对应的课程剩余报名人数-1
                courseService.updateSurplusById(course.getId());
                redirectAttributes.addFlashAttribute("msgSuccess","成功提示：报名成功");
                return "redirect:/admin/apply/list";
            }else {
                redirectAttributes.addFlashAttribute("msgSuccess","失败提示：报名失败");
                return "redirect:/admin/apply/list";
            }
        }
        else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：报名失败，课程满人");
            return "redirect:/admin/apply/list";
        }
    }

    /**
     * 跳转编辑页面
     * @param id
     * @param map
     * @param redirectAttributes
     * @param session
     * @return
     */
    @GetMapping("/editApply")
    public String editCourse(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,
                             HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        List<Course> courseList = courseService.selectAll();
        map.put("courseList", courseList);
        Apply_pay apply_pay = applyService.selectByPrimaryKey(id);
        map.put("apply_pay",apply_pay);
        // 修改时间格式
        if(apply_pay.getPayTime() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String pay_time = sdf.format(apply_pay.getPayTime());
            map.put("pay_time",pay_time);
        }
        return "manager/admin/apply_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/29
     */
    @RequestMapping("/editApply.do")
    public String edit(Apply_pay apply_pay, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
        //检查报名学生不能为空
        if (apply_pay.getPayStudent().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：报名学生不能为空！");
            return "redirect:/admin/apply/addApply";
        }
        //检查课程ID不能为空
        if (apply_pay.getCourseId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程ID不能为空！");
            return "redirect:/admin/apply/addApply";
        }
//        //检查报名课时不能为空
//        if (apply_pay.getHour() == null) {
//            redirectAttributes.addFlashAttribute("msgError", "错误提示：报名课时不能为空！");
//            return "redirect:/admin/apply/addApply";
//        }
        //存储数据
        if(applyService.updateByPrimaryKey(apply_pay)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
            return "redirect:/admin/apply/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：修改失败");
            return "redirect:/admin/apply/list";
        }
    }
}

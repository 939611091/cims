package com.cims.controller.admin;



import com.cims.entity.Student;
import com.cims.service.AStudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/admin/student")
public class AStudentController {
    @Autowired
    private AStudentService aStudentService;
    /**
     * 列表页面
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据大小
     * @param map      传到页面的 model
     * @return jsp页面
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        PageInfo<Student> pageResult = aStudentService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/student_list";
    }

    /**
     * 添加界面
     *
     * @return jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/addStudent")
    public String addStudent(RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/student_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/addStudent.do")
    public String add(Student student, RedirectAttributes redirectAttributes) {
        //检查用户名不能为空
        if (student.getUsername().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：用户名不能为空！");
            return "redirect:/admin/student/addStudent";
        }
        if (student.getPassword().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：密码不能为空！");
            return "redirect:/admin/student/addStudent";
        }
        if (aStudentService.selectByUsername(student.getUsername()) > 0){
            redirectAttributes.addFlashAttribute("msgError","错误提示：用户名已存在，请重试。");
            return "redirect:/admin/student/addStudent";
        }
        //验证手机号码的合理性
        if (!student.getpPhone().equals("")){
            Pattern pattern = Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$");
            Boolean result = pattern.matcher(student.getpPhone()).matches();
            if(!result){
                redirectAttributes.addFlashAttribute("msgError","错误提示：手机号码格式有误请检查确认");
                return "redirect:/admin/student/addStudent";
            }
        }
        //存储数据
        aStudentService.insert(student);

        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");

        return "redirect:/admin/student/list";
    }

    /**
     * 修改申请页面
     *
     * @author vanh
     * @date 2019/7/20
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/editStudent")
    public String editStudent(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Student student = aStudentService.selectByPrimaryKey(id);

        map.put("student",student);

        return "manager/admin/student_edit";
    }


    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/editStudent.do")
    public String edit(Student student, RedirectAttributes redirectAttributes) {
//        根据id查该用户的密码赋给password
        String password = aStudentService.selectPasswordById(student.getstudentId());

        if(student.getPassword()!=""){
            student.setPassword(student.getPassword());
        }else{
            student.setPassword(password);
        }
        if(aStudentService.updateByPrimaryKey(student)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }
        return "redirect:/admin/student/list";


    }

    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        aStudentService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/student/list";
    }
}

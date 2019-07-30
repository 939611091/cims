package com.cims.controller.teacher;

import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/teacher")
public class TeacherIndexController {
    @Autowired
    private TeacherService teacherService;
    //跳转登录页面
    @GetMapping("/login")
    public String login() {
        return "manager/teacher/teacher_login";
    }
    /**
     * 登录操作
     * @param username 用户名
     * @param password 密码
     * @param session session
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes ) {

        if (username.equals("")){
            redirectAttributes.addFlashAttribute("msg","用户名不能为空");
            return "redirect:/teacher/login";
        }
        Teacher teacher = teacherService.login(username,password);
        if (teacher != null){
            session.setAttribute("teacher",teacher);
            return "manager/teacher/index";
        }else {
            redirectAttributes.addFlashAttribute("msg","错误提示：用户名和密码错误，请重试。");
            return "redirect:/teacher/login";
        }
    }
    //退出用户
    @GetMapping("exit")
    public String exitUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        //从session判断admin是否存在，即可判断用户是否登录
        if (session.getAttribute("teacher") != null) {
            //使当前session的user无效
            session.removeAttribute("teacher");

        }
        return "redirect:/teacher/login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,RedirectAttributes redirectAttributes) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        return "manager/teacher/index";
    }
}

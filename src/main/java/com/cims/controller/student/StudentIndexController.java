package com.cims.controller.student;

import com.cims.entity.Student;
import com.cims.service.StudentService;
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
@RequestMapping("/student")
public class StudentIndexController {
    @Autowired
    private StudentService studentService;
    //跳转登录页面
    @GetMapping("/login")
    public String login() {
        return "manager/student/student_login";
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
            return "redirect:/student/login";
        }
        Student student = studentService.login(username,password);
        if (student != null){
            session.setAttribute("student",student);
            return "manager/student/index";
        }else {
            redirectAttributes.addFlashAttribute("msg","错误提示：用户名和密码错误，请重试。");
            return "redirect:/student/login";
        }
    }
    //退出用户
    @GetMapping("exit")
    public String exitUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        //从session判断admin是否存在，即可判断用户是否登录
        if (session.getAttribute("student") != null) {
            //使当前session的user无效
            session.removeAttribute("student");

        }
        return "redirect:/student/login";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,RedirectAttributes redirectAttributes) {
        if (session.getAttribute("student")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/student/login";
        }
        return "manager/student/index";
    }
}

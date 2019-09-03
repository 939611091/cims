package com.cims.controller.admin;

import com.cims.entity.Admin;
import com.cims.entity.User;
import com.cims.service.AdminService;
import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
public class AdminIndexController {
    //用于测试
//    @Autowired
//    private UserService userService;

    @Autowired
    private AdminService adminService;


    //跳转登录页面
    @GetMapping("/login")
    public String login() {
        return "manager/admin/admin_login";
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
            return "redirect:/admin/login";
        }



        Admin admin = adminService.login(username,password);
        if (admin != null){
            session.setAttribute("admin",admin);
            return "manager/admin/index";
        }else {
            redirectAttributes.addFlashAttribute("msg","错误提示：用户名和密码错误，请重试。");
            return "redirect:/admin/login";
        }



    }

    //退出用户
    @GetMapping("exit")
    public String exitUser(HttpServletRequest request) {

        HttpSession session = request.getSession();
        //从session判断admin是否存在，即可判断用户是否登录
        if (session.getAttribute("admin") != null) {
            //使当前session的user无效
            session.removeAttribute("admin");

        }
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(HttpSession session,RedirectAttributes redirectAttributes) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/index";
    }





}

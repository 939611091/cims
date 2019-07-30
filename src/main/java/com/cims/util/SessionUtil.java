package com.cims.util;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public String  getAttribute(HttpSession session,RedirectAttributes redirectAttributes){
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "redirect:/admin/index";
    }
}

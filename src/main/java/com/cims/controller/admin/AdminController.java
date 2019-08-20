package com.cims.controller.admin;


import com.cims.entity.Admin;
import com.cims.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;



@Controller
@RequestMapping("/admin/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //    查询所有管理员信息
//    @GetMapping("/admin_list")
//    public ModelAndView getAllAdmin(){
//        ModelAndView mv = new ModelAndView();
//        List<Admin> list = adminService.getAllAdmin();
//        mv.addObject("adminList",list);
//        mv.setViewName("manager/admin/admin_list");
//        return mv;
//    }

    /**
     * 管理员列表页面
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据大小
     * @param map      传到页面的 model
     * @return jsp页面
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params,RedirectAttributes redirectAttributes,HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        PageInfo<Admin> pageResult = adminService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/admin_list";
    }

    /**
     * 添加用户界面
     *
     * @return String manager/admin/articles_publish.jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/addAdmin")
    public String addUser(RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }

        return "manager/admin/admin_add";
    }

    /**
     * 添加用户API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/addAdmin.do")
    public String add(Admin admin, RedirectAttributes redirectAttributes,HttpSession session) {
        //检查用户名不能为空
        if(admin.getUsername().equals("")){
            redirectAttributes.addFlashAttribute("msgError","错误提示：用户名不能为空！");
            return "redirect:/admin/admin/addAdmin";
        }
        if(admin.getPassword().equals("")){
            redirectAttributes.addFlashAttribute("msgError","错误提示：密码不能为空！");
            return "redirect:/admin/admin/addAdmin";
        }
        if (adminService.selectByUsername2(admin.getUsername()) > 0){
            redirectAttributes.addFlashAttribute("msgError","错误提示：用户名已存在，请重试。");
            return "redirect:/admin/admin/addAdmin";
        }


        //存储数据
        adminService.insert(admin);

        redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");

        return "redirect:/admin/admin/list";


    }

    /**
     * 管理员修改申请页面
     *
     * @author vanh
     * @date 2019/6/26
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/editAdmin")
    public String editAdmin(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Admin admin = adminService.selectByPrimaryKey(id);
        Integer adminId=((Admin)session.getAttribute("admin")).getAdminId();
        //ID为1的可以编辑所有管理员
        if(adminId == 1){
            map.put("admin",admin);
        }else {
            //其他管理员只能编辑自己的信息
            if(admin.getAdminId() == adminId){
                map.put("admin",admin);
            }else{
                redirectAttributes.addFlashAttribute("msgSuccess","失败提示：你只能编辑自己的信息");
                return "redirect:/admin/admin/list";
            }
        }





        return "manager/admin/admin_edit";
    }

    /**
     * 修改管理员API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/editAdmin.do")
    public String edit(Admin admin, RedirectAttributes redirectAttributes) {
        //根据id查该用户的密码赋给password
        String password = adminService.selectPasswordById(admin.getAdminId());

        if(admin.getPassword()!=""){
            admin.setPassword(admin.getPassword());
        }else{
            admin.setPassword(password);
        }
        if(adminService.updateByPrimaryKey(admin)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }


        return "redirect:/admin/admin/list";


    }


}
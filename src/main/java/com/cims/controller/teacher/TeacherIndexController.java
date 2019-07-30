package com.cims.controller.teacher;

import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.ATeacherService;
import com.cims.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/teacher")
public class TeacherIndexController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ATeacherService aTeacherService;
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

    /**
     * 跳转编辑页面
     * @param id
     * @param map
     * @param redirectAttributes
     * @param session
     * @return
     */
    @GetMapping("/edit")
    public String editTeacher(Integer id, Map<String, Object> map, RedirectAttributes redirectAttributes,
                              HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        Teacher teacher = aTeacherService.selectByPrimaryKey(id);

        map.put("teacher",teacher);

        return "manager/teacher/teacher_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/edit.do")
    public String edit(Teacher teacher, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
//        根据id查该用户的密码赋给password
        String password = aTeacherService.selectPasswordById(teacher.getteacherId());

        if(teacher.getPassword().equals("")){
            teacher.setPassword(password);
        }else{
            teacher.setPassword(teacher.getPassword());
        }
        //名字不能为空
        if (teacher.getName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：真实姓名不能为空！");
            return "redirect:/teacher/edit";
        }


        //判断fil是否为空，为空则直接更新用户
        if (fil.getSize() == 0){
//            teacher.setPassword(password);
            aTeacherService.updateByPrimaryKey(teacher);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
            return "redirect:/teacher/edit";
        }

        //更新所选图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大");
            return "redirect:/teacher/edit";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/teacher/edit";
        }

        //文件的名称，设置文件的另存为的名称
        String fileName = uuid+substring;
        //设置图片上传路径 ${pageContext.request.contextPath }/upload/${items.pic }   法2
        String url = req.getSession().getServletContext().getRealPath("/imgs");
//        System.out.println(url);

        //定义一个文件fi来查看真实路径是否存在，如果不存在就创建fi     fi是存放服务器真实路径的
        File fi = new File(url);

        //解决文件名必须给出，没有则报错,所以判断是否存在
        if(!fi.exists()) {
            //没有这个文件夹则创建
            fi.mkdirs();
        }

        //file为存到服务器路径的文件，把名为fileName文件，存到真实路径fi中
        File file = new File(fi,fileName);
        //实现文件上传
        try {
            //把前端fil的文件传给服务器file
            fil.transferTo(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //设置图片名xxx.jpg存入数据库pic字段
        teacher.settPhoto("imgs/"+fileName);


        //更新数据
        if(aTeacherService.updateByPrimaryKey(teacher)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
        }else {
            redirectAttributes.addFlashAttribute("msgError","错误提示：修改失败");
        }
        return "redirect:/teacher/edit";


    }
}

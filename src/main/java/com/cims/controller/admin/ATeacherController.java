package com.cims.controller.admin;

import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.ATeacherService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin/teacher")
public class ATeacherController {
    @Autowired
    private ATeacherService aTeacherService;

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
        PageInfo<Teacher> pageResult = aTeacherService.selectByMap(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/admin/teacher_list";
    }

    /**
     * 添加界面
     *
     * @return jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/addTeacher")
    public String addTeacher(RedirectAttributes redirectAttributes,HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/teacher_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/addTeacher.do")
    public String add(Teacher teacher, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
        //检查用户名不能为空
        if (teacher.getUsername().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：用户名不能为空！");
            return "redirect:/admin/teacher/addTeacher";
        }
        //密码不能为空
        if (teacher.getPassword().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：密码不能为空！");
            return "redirect:/admin/teacher/addTeacher";
        }
        if (teacher.getName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：真实姓名不能为空！");
            return "redirect:/admin/teacher/addTeacher";
        }
        //检查是否重名
        if (aTeacherService.selectByUsername(teacher.getUsername()) > 0){
            redirectAttributes.addFlashAttribute("msgError","错误提示：用户名已存在，请重试。");
            return "redirect:/admin/teacher/addTeacher";
        }

        //判断fil是否为空，为空则直接添加用户
        if (fil.getSize() == 0){
            aTeacherService.insert(teacher);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
            return "redirect:/admin/teacher/list";
        }

        //上传图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大,不能超过5M");
            return "redirect:/admin/teacher/addTeacher";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/admin/teacher/addTeacher";
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
        //存储数据

        if(aTeacherService.insert(teacher)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");

            return "redirect:/admin/teacher/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：添加失败");

            return "redirect:/admin/teacher/list";
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
    @GetMapping("/editTeacher")
    public String editTeacher(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,
                              HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Teacher teacher = aTeacherService.selectByPrimaryKey(id);

        map.put("teacher",teacher);

        return "manager/admin/teacher_edit";
    }

    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/editTeacher.do")
    public String edit(Teacher teacher, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
//        根据id查该用户的密码赋给password
        String password = aTeacherService.selectPasswordById(teacher.getteacherId());

        if(teacher.getPassword()!=""){
            teacher.setPassword(teacher.getPassword());
        }else{
            teacher.setPassword(password);
        }
        //名字不能为空
        if (teacher.getName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：真实姓名不能为空！");
            return "redirect:/admin/teacher/addTeacher";
        }


        //判断fil是否为空，为空则直接更新用户
        if (fil.getSize() == 0){
            aTeacherService.updateByPrimaryKey(teacher);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
            return "redirect:/admin/teacher/list";
        }

        //更新所选图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大");
            return "redirect:/admin/teacher/addTeacher";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/admin/teacher/addTeacher";
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
        return "redirect:/admin/teacher/list";


    }


    /**
     * 删除
     * @author vanh
     * @date 2019/7/20
     */
    @GetMapping("/delete.do")
    public String delete(Integer id, RedirectAttributes redirectAttributes) {
        aTeacherService.deleteByPrimaryKey(id);
        redirectAttributes.addFlashAttribute("msgError","成功提示：删除成功");
        return "redirect:/admin/teacher/list";
    }

}

package com.cims.controller.admin;

import com.cims.entity.Course;
import com.cims.entity.Honor;
import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.AStudentService;
import com.cims.service.HonorService;
import com.cims.vo.HonorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin/honor")
public class HonorController {
    @Autowired
    private HonorService honorService;
    @Autowired
    private AStudentService aStudentService;

    @RequestMapping("/list")
    public String index(Model model,RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        List<HonorVo> honorVoList = honorService.selectAll();
        model.addAttribute("honorVoList",honorVoList);
        return "manager/admin/honor_list";
    }

    /**
     * 添加界面
     *
     * @return jsp页面
     * @author vanh
     * @date 2019/7/19
     */
    @GetMapping("/hint")
    public String hint(RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        return "manager/admin/honor_hint";
    }

    /**
     * 添加荣誉页面
     *
     * @author vanh
     * @date 2019/7/26
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/addHonor")
    public String addHonor(Integer id, Map<String, Object> map, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Student student = aStudentService.selectByPrimaryKey(id);

        map.put("student",student);

        return "manager/admin/honor_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/16
     */
    @PostMapping("/addHonor.do")
    public String add(Honor honor, Map<String, Object> map,RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {

        //判断fil是否为空，为空则直接添加用户
        if (fil.getSize() == 0){
            honorService.insert(honor);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
            return "redirect:/admin/honor/list";
        }

        //上传图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大,不能超过5M");
            return "redirect:/admin/honor/addHonor";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/admin/honor/addHonor";
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
        honor.sethPhoto("imgs/"+fileName);
        //存储数据

        if(honorService.insert(honor)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");

            return "redirect:/admin/honor/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：添加失败");

            return "redirect:/admin/honor/list";
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
    @GetMapping("/editHonor")
    public String editHonor(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,
                             HttpSession session) {
        if (session.getAttribute("admin")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/admin/login";
        }
        Honor honor = honorService.selectByPrimaryKey(id);
        map.put("honor",honor);
        // 修改时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String h_time = sdf.format(honor.getTime());
        map.put("h_time",h_time);
        return "manager/admin/honor_edit";
    }


    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/editHonor.do")
    public String edit(Honor honor, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
        //判断fil是否为空，为空则直接添加用户
        if (fil.getSize() == 0){
            honorService.updateByPrimaryKey(honor);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");
            return "redirect:/admin/honor/list";
        }

        //上传图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大,不能超过5M");
            return "redirect:/admin/honor/editHonor";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/admin/honor/editHonor";
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
        honor.sethPhoto("imgs/"+fileName);
        //存储数据

        if(honorService.updateByPrimaryKey(honor)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：修改成功");

            return "redirect:/admin/honor/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：修改失败");

            return "redirect:/admin/honor/list";
        }

    }
}

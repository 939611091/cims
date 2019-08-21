package com.cims.controller.teacher;

import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import com.cims.service.ATeacherService;
import com.cims.service.CourseCategoryService;
import com.cims.service.CourseService;
import com.cims.service.TeacherService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseDetailsVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/teacher/course")
public class TCourseController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseCategoryService courseCategoryService;
    @Autowired
    private ATeacherService aTeacherService;
    //查出这个老师ID对应的课程列出来
    @RequestMapping(value = "/myList", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        //从session获取老师ID
        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        //查询这个老师的课程
        List<CourseVo> courseVoList = teacherService.selectByTeacherId(teacherId);
        model.addAttribute("courseVoList",courseVoList);
        return "manager/teacher/myCourse_list";
    }

    /**
     * 前端模态框数据
     */
    @PostMapping("/modeDate")
    @ResponseBody
    public CourseDetailsVo modeDate(HttpServletRequest request)  {
        //id是课程ID
        Integer id = Integer.parseInt(request.getParameter("id"));
        //根据课程ID查课程详情
        CourseDetailsVo course = courseService.selectById(id);

        return course;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam(required = false, defaultValue = "1") int pageNum,
                       @RequestParam(required = false, defaultValue = "10") int pageSize,
                       @RequestParam Map<String, Object> params, RedirectAttributes redirectAttributes, HttpSession session,
                       Map<String, Object> map) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        PageInfo<CourseVo> pageResult = teacherService.selectByMap2(params, pageNum, pageSize);
        map.put("pageResult", pageResult);
        map.put("params", params);
        return "manager/teacher/course_list";
    }


    //只能发布自己的课程
    /**
     * 发布课程页面
     * 查出所有课程类别和老师
     * @param map
     * @return jsp页面
     */
    @GetMapping("/addCourse")
    public String addCourse(Map<String, Object> map,RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        List<Course_category> courseCategoryList = courseCategoryService.selectAll();
        map.put("courseCategoryList", courseCategoryList);

        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        Teacher teacher = aTeacherService.selectByPrimaryKey(teacherId);
        map.put("teacherList",teacher);
        return "manager/teacher/course_add";
    }

    /**
     * 添加API
     *
     * @author vanh
     * @date 2019/7/19
     */
    @PostMapping("/addCourse.do")
    public String add(Course course, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {

        //检查课程名不能为空
        if (course.getcName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程名不能为空！");
            return "redirect:/teacher/course/addCourse";
        }
        //检查课程类别不能为空
        if (course.getCourseCategoryId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程类别不能为空！");
            return "redirect:/teacher/course/addCourse";
        }
        //检查老师不能为空
        if (course.getTeacherId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：老师不能为空！");
            return "redirect:/teacher/course/addCourse";
        }
        //检查课程人数不能为空
        if (course.getNumber() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程人数不能为空！");
            return "redirect:/teacher/course/addCourse";
        }


        //判断fil是否为空，为空则直接添加
        if (fil.getSize() == 0){
            courseService.insert(course);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
            return "redirect:/teacher/course/list";
        }

        //上传图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大,不能超过5M");
            return "redirect:/teacher/course/addCourse";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/teacher/course/addCourse";
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
        course.setcPhoto("imgs/"+fileName);

        //存储数据
        if(courseService.insert(course)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：添加成功");
            return "redirect:/teacher/course/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：添加失败");

            return "redirect:/teacher/course/list";
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
    @GetMapping("/editCourse")
    public String editCourse(Integer id, Map<String, Object> map,RedirectAttributes redirectAttributes,
                             HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        Course course = courseService.selectByPrimaryKey(id);
        map.put("course",course);
        // 修改时间格式
        if(course.getBeginTime() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String b_time = sdf.format(course.getBeginTime());
            map.put("b_time",b_time);
        }
        if(course.getOverTime() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String o_time = sdf.format(course.getOverTime());
            map.put("o_time",o_time);
        }
        //只能编辑自己的课程
        Integer teacherId=((Teacher)session.getAttribute("teacher")).getteacherId();
        if(course.getTeacherId() != teacherId){
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：你只能编辑自己的课程");
            return "redirect:/teacher/course/list";
        }


        List<Course_category> courseCategoryList = courseCategoryService.selectAll();
        map.put("courseCategoryList", courseCategoryList);

        Teacher teacher = aTeacherService.selectByPrimaryKey(teacherId);
        map.put("teacherList",teacher);



        return "manager/teacher/course_edit";
    }


    /**
     * 修改API
     *
     * @author vanh
     * @date 2019/7/26
     */
    @RequestMapping("/editCourse.do")
    public String edit(Course course, RedirectAttributes redirectAttributes, MultipartFile fil, HttpServletRequest req) {
        //检查课程名不能为空
        if (course.getcName().equals("")) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程名不能为空！");
            return "redirect:/teacher/course/editCourse";
        }
        //检查课程类别不能为空
        if (course.getCourseCategoryId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程类别不能为空！");
            return "redirect:/teacher/course/editCourse";
        }
        //检查老师不能为空
        if (course.getTeacherId() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：老师不能为空！");
            return "redirect:/teacher/course/editCourse";
        }
        //检查课程人数不能为空
        if (course.getNumber() == null) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：课程人数不能为空！");
            return "redirect:/teacher/course/editCourse";
        }


        //判断fil是否为空，为空则直接更新用户
        if (fil.getSize() == 0){
            courseService.updateByPrimaryKey(course);
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：更新成功");
            return "redirect:/teacher/course/list";
        }
        //上传图片
        //判断前台上传文件大小
        if(fil.getSize()>5*1024*1024) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传图片太大,不能超过5M");
            return "redirect:/teacher/course/editCourse";
        }
        //UUID解决文件名称重复的问题
        //生成一个uuid并用空替换-
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //文件后缀，getOriginalFilename获取上传文件的名字，截取.后面的判断文件类型
        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        //指定上传文件的类型.png,.jpg,.gif
        if(!(".png".equals(substring) || ".jpg".equals(substring) || ".gif".equals(substring))) {
            redirectAttributes.addFlashAttribute("msgError", "错误提示：上传的文件类型不匹配，必须是jpg,png,gif!");
            return "redirect:/teacher/course/editCourse";
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
        course.setcPhoto("imgs/"+fileName);



        //存储数据
        if(courseService.updateByPrimaryKey(course)>0){
            redirectAttributes.addFlashAttribute("msgSuccess","成功提示：更新成功");
            return "redirect:/teacher/course/list";
        }else {
            redirectAttributes.addFlashAttribute("msgSuccess","失败提示：更新失败");

            return "redirect:/teacher/course/list";
        }
    }

    /**
     * 查出这个课程的学生
     * @param id
     * @param model
     * @param redirectAttributes
     * @param session
     * @return
     */
    @RequestMapping(value = "/studentList", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Integer id, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        if (session.getAttribute("teacher")==null){
            redirectAttributes.addFlashAttribute("msg","未登录,请先登录");
            return "redirect:/teacher/login";
        }
        Course course = courseService.selectByPrimaryKey(id);
        model.addAttribute("course",course);
        List<Apply_payVo> apply_payVoList = teacherService.selectByCourseId(id);
        model.addAttribute("apply_payVoList",apply_payVoList);

        return "manager/teacher/course_studentList";
    }
    /**
     * 跳转打印页面
     * @param id
     * @param model
     * @param redirectAttributes
     * @param session
     * @return
     */
    @GetMapping("/printStudentList")
    public String printStudentList(Integer id, Model model,RedirectAttributes redirectAttributes,
                                   HttpSession session) {
        if (session.getAttribute("teacher") == null) {
            redirectAttributes.addFlashAttribute("msg", "未登录,请先登录");
            return "redirect:/teacher/login";
        }
        Course course = courseService.selectByPrimaryKey(id);
        model.addAttribute("course",course);
        Teacher teacher = aTeacherService.selectByPrimaryKey(course.getTeacherId());
        model.addAttribute("teacher",teacher);
        List<Apply_payVo> apply_payVoList = teacherService.selectByCourseId(id);
        model.addAttribute("apply_payVoList",apply_payVoList);

        return "manager/teacher/studentList_print";
    }
}

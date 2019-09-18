package com.cims.service.impl;

import com.cims.dao.*;
import com.cims.entity.*;
import com.cims.service.CourseCategoryService;
import com.cims.service.TeacherService;
import com.cims.util.MD5Util;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private Course_categoryMapper course_categoryMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Apply_payMapper apply_payMapper;
    @Override
    public Teacher login(String username, String password) {
        //对输入的密码进行加密然后和数据库比对
        String md5Password = MD5Util.MD5EncodeUtf8(password);

        Teacher teacher = teacherMapper.selectLogin(username,md5Password);
        if (teacher != null){
            //把密码设为空，防止别人获取
            teacher.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            return teacher;
        }else {
            return null;
        }

    }

    @Override
    public List<CourseVo> selectByTeacherId(Integer id) {
        //查出所有课程
        List<Course> courseList = courseMapper.selectByTeacherId(id);
        //定义课程VO列表
        List<CourseVo> courseVoList = new LinkedList<>();
        //把课程逐个转成课程VO
        for (Course course : courseList) {
            courseVoList.add(assembleCourseVo(course));
        }
        return courseVoList;
    }

    @Override
    public PageInfo<CourseVo> selectByMap2(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有课程
        List<Course> courseList = courseMapper.selectByMap2(map);
        //定义课程VO列表
        List<CourseVo> courseVoList = new LinkedList<>();
        //把课程逐个转成课程VO
        for (Course course : courseList) {
            courseVoList.add(assembleCourseVo(course));
        }
        //定义返回pageInfo结果集把课程列表传进去
        PageInfo pageResult = new PageInfo(courseList);
        //把vo传到结果集
        pageResult.setList(courseVoList);
        return pageResult;
    }

    @Override
    public List<Apply_payVo> selectByCourseId(Integer id) {
        List<Apply_pay> apply_payList = apply_payMapper.selectByCourseId(id);
        List<Apply_payVo> apply_payVoList = new LinkedList<>();
        for (Apply_pay apply_pay : apply_payList) {
            apply_payVoList.add(assembleApplyVo(apply_pay));
        }
        return apply_payVoList;
    }

//    @Override
//    public int insert(Course course) {
//        return courseMapper.insert(course);
//    }


    /**
     * Course转换成CourseVo
     * 用 BeanUtils.copyProperties(原对象, 目标对象) 把 Course 中的基本信息复制到 CourseVo 中
     * 通过 Course 中的 id 获取 对应ID的信息
     * @param course
     * @return courseVo
     */
    private CourseVo assembleCourseVo(Course course) {
        CourseVo courseVo = new CourseVo();
        BeanUtils.copyProperties(course, courseVo);
        //把ccid查出的course_category传给courseVo
        Course_category course_category = course_categoryMapper.selectByPrimaryKey(course.getCourseCategoryId());
        courseVo.setCourse_category(course_category);
        //把老师ID查出的老师实体传给courseVo
        Teacher teacher = teacherMapper.selectByPrimaryKey(course.getTeacherId());
        courseVo.setTeacher(teacher);
        return courseVo;
    }

    private Apply_payVo assembleApplyVo(Apply_pay apply_pay) {
        Apply_payVo apply_payVo = new Apply_payVo();
        BeanUtils.copyProperties(apply_pay, apply_payVo);
        //把courseid查出的course传给apply_payVo
        Course course = courseMapper.selectByPrimaryKey(apply_pay.getCourseId());
        apply_payVo.setCourse(course);
        //把学生ID查出的学生实体传给apply_payVo
        Student student = studentMapper.selectByPrimaryKey(apply_pay.getStudentId());
        apply_payVo.setStudent(student);
        return apply_payVo;
    }
}

package com.cims.service.impl;

import com.cims.dao.CourseMapper;
import com.cims.dao.Course_categoryMapper;
import com.cims.dao.TeacherMapper;
import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import com.cims.service.CourseCategoryService;
import com.cims.service.TeacherService;
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
    @Override
    public Teacher login(String username, String password) {
        return teacherMapper.selectLogin(username,password);
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
}

package com.cims.service.impl;

import com.cims.dao.CourseMapper;
import com.cims.dao.Course_categoryMapper;
import com.cims.dao.TeacherMapper;
import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import com.cims.service.CourseService;
import com.cims.vo.CourseDetailsVo;
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
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private Course_categoryMapper course_categoryMapper;

    @Autowired
    private TeacherMapper teacherMapper;


    /**
     * 列表服务
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据大小
     * @param map      传到页面的 model
     * @return pageResult保存着courseVoList
     */
    @Override
    public PageInfo<CourseVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有课程
        List<Course> courseList = courseMapper.selectByMap(map);
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
    public List<CourseVo> selectByCategoryId(Integer id) {
        //用于前端只显示最新的五个
        List<Course> courseList = courseMapper.selectByCategoryId(id);
        List<CourseVo> courseVoList = new LinkedList<>();
        for (Course course : courseList) {
            courseVoList.add(assembleCourseVo(course));
        }

        return courseVoList;
    }

    @Override
    public int insert(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public Course selectByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public int updateSurplusById(Integer id) {
        return courseMapper.updateSurplusById(id);
    }

    @Override
    public CourseDetailsVo selectById(Integer id) {
        Course course = courseMapper.selectById(id);
        CourseDetailsVo courseDetailsVo = assembleCourseDVo(course);
        return courseDetailsVo;
    }

    @Override
    public int deleteByCategoryId(Integer id) {
        return courseMapper.deleteByCategoryId(id);
    }

    @Override
    public List<CourseVo> selectCourseBySix() {
        List<Course> courseList = courseMapper.selectCourseBySix();
        List<CourseVo> courseVoList = new LinkedList<>();
        for (Course course : courseList) {
            courseVoList.add(assembleCourseVo(course));
        }

        return courseVoList;
    }


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

    private CourseDetailsVo assembleCourseDVo(Course course) {
        CourseDetailsVo courseDetailsVo = new CourseDetailsVo();
        BeanUtils.copyProperties(course, courseDetailsVo);
        //把ccid查出的course_category传给courseVo
        Course_category course_category = course_categoryMapper.selectByPrimaryKey(course.getCourseCategoryId());
        courseDetailsVo.setCategoryName(course_category.getcategoryName());
        //把老师ID查出的老师实体传给courseVo
        Teacher teacher = teacherMapper.selectByPrimaryKey(course.getTeacherId());
        courseDetailsVo.setTeacherName(teacher.getName());
        return courseDetailsVo;
    }
}

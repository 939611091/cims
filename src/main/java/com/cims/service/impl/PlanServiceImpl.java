package com.cims.service.impl;

import com.cims.dao.ClassroomMapper;
import com.cims.dao.CourseMapper;
import com.cims.dao.Course_classroomMapper;
import com.cims.entity.*;
import com.cims.service.ClassroomService;
import com.cims.service.CourseService;
import com.cims.service.PlanService;
import com.cims.vo.CourseVo;
import com.cims.vo.Course_classroomVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private Course_classroomMapper course_classroomMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassroomMapper classroomMapper;
    @Override
    public PageInfo<Course_classroomVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有安排
        List<Course_classroom> course_classroomList = course_classroomMapper.selectByMap(map);
        //定义安排VO列表
        List<Course_classroomVo> course_classroomVoList = new LinkedList<>();
        //把课程逐个转成课程VO
        for (Course_classroom course_classroom : course_classroomList) {
            course_classroomVoList.add(assembleCourseCVo(course_classroom));
        }
        //定义返回pageInfo结果集把课程列表传进去
        PageInfo pageResult = new PageInfo(course_classroomList);
        //把vo传到结果集
        pageResult.setList(course_classroomVoList);
        return pageResult;
    }

    @Override
    public int insert(Course_classroom course_classroom) {
        return course_classroomMapper.insert(course_classroom);
    }

    @Override
    public Course_classroom selectByPrimaryKey(Integer id) {
        return course_classroomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Course_classroom course_classroom) {
        return course_classroomMapper.updateByPrimaryKey(course_classroom);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return course_classroomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int selectByCourseId(Integer id) {
        return course_classroomMapper.selectByCourseId(id);
    }

    private Course_classroomVo assembleCourseCVo(Course_classroom course_classroom) {
        Course_classroomVo course_classroomVo = new Course_classroomVo();
        BeanUtils.copyProperties(course_classroom, course_classroomVo);
        //把ccid查出的course_category传给course_classroomVo
        Course course = courseMapper.selectByPrimaryKey(course_classroom.getCourseId());
        course_classroomVo.setCourse(course);
        //把教室ID查出的老师实体传给course_classroomVo
        Classroom classroom = classroomMapper.selectByPrimaryKey(course_classroom.getClassroomId());
        course_classroomVo.setClassroom(classroom);
        return course_classroomVo;
    }
}

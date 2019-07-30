package com.cims.service;

import com.cims.entity.Course;
import com.cims.entity.Course_classroom;
import com.cims.vo.CourseVo;
import com.cims.vo.Course_classroomVo;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface PlanService {
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<Course_classroomVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);
    //添加
    int insert(Course_classroom course_classroom);
    //根据主键查
    Course_classroom selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Course_classroom course_classroom);
    //删除
    int deleteByPrimaryKey(Integer id);
    //根据是否安排
    int selectByCourseId(Integer id);
}

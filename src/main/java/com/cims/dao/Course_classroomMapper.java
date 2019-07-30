package com.cims.dao;

import com.cims.entity.Course;
import com.cims.entity.Course_classroom;

import java.util.List;
import java.util.Map;

public interface Course_classroomMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course_classroom record);

    int insertSelective(Course_classroom record);

    Course_classroom selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course_classroom record);

    int updateByPrimaryKey(Course_classroom record);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Course_classroom> selectByMap(Map<String, Object> map);

    /**
     * 查询是否重复
     * @param courseId
     * @return
     */
    int selectByCourseId(Integer courseId);
}
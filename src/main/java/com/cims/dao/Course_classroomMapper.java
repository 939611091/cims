package com.cims.dao;

import com.cims.entity.Course_classroom;

public interface Course_classroomMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course_classroom record);

    int insertSelective(Course_classroom record);

    Course_classroom selectByPrimaryKey(Integer courseId);

    int updateByPrimaryKeySelective(Course_classroom record);

    int updateByPrimaryKey(Course_classroom record);
}
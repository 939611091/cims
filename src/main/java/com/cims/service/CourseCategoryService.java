package com.cims.service;

import com.cims.entity.Course_category;

import java.util.List;

public interface CourseCategoryService {
    //查询所有
    List<Course_category> selectAll();
    //删除
    int deleteByPrimaryKey(Integer id);
    //添加
    int insert(Course_category course_category);
    //根据主键查
    Course_category selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Course_category course_category);
}

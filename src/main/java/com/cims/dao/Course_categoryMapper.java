package com.cims.dao;


import com.cims.entity.Course_category;

import java.util.List;

public interface Course_categoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course_category record);

    int insertSelective(Course_category record);

    Course_category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course_category record);

    int updateByPrimaryKey(Course_category record);

    List<Course_category> selectAll();
}
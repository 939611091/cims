package com.cims.service.impl;

import com.cims.dao.Course_categoryMapper;
import com.cims.entity.Course_category;
import com.cims.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

    @Autowired
    private Course_categoryMapper course_categoryMapper;

    @Override
    public List<Course_category> selectAll() {
        return course_categoryMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return course_categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Course_category course_category) {
        return course_categoryMapper.insert(course_category);
    }

    @Override
    public Course_category selectByPrimaryKey(Integer id) {
        return course_categoryMapper.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKey(Course_category course_category) {
        return course_categoryMapper.updateByPrimaryKey(course_category);
    }
}

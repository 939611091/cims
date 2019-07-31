package com.cims.dao;

import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.vo.CourseVo;


import java.util.List;
import java.util.Map;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    Course selectById(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Course> selectByMap(Map<String, Object> map);

    List<Course> selectByCategoryId(Integer id);

    List<Course> selectAll();

    int updateSurplusById(Integer id);
}
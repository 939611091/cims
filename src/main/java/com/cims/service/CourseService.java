package com.cims.service;

import com.cims.entity.Course;
import com.cims.entity.Course_category;
import com.cims.entity.Teacher;
import com.cims.vo.CourseDetailsVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface CourseService {

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<CourseVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);
    //用于前端分类
    List<CourseVo> selectByCategoryId(Integer id);
    //添加
    int insert(Course course);
    //根据主键查
    Course selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Course course);
    //删除
    int deleteByPrimaryKey(Integer id);

    //查询所有
    List<Course> selectAll();
    //报名成功后更新剩余名额
    int updateSurplusById(Integer id);

    //根据id查vo
    CourseDetailsVo selectById(Integer id);
}

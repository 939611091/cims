package com.cims.service;

import com.cims.entity.Course;
import com.cims.entity.Teacher;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    //登录
    Teacher login(String username, String password);
    //查出这个老师所有的课程
    List<CourseVo> selectByTeacherId(Integer id);
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<CourseVo> selectByMap2(Map<String, Object> map, int pageNum, int pageSize);

    //查出这个课程的所有报名单
    List<Apply_payVo> selectByCourseId(Integer id);
}

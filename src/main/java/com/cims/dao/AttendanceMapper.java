package com.cims.dao;

import com.cims.entity.Attendance;
import com.cims.entity.Attendance_status;


import java.util.List;
import java.util.Map;

public interface AttendanceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
    //根据老师ID去查考勤记录
    List<Attendance> selectByMap(Map<String, Object> map);
}
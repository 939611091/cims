package com.cims.dao;

import com.cims.entity.Attendance_status;

import java.util.List;

public interface Attendance_statusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendance_status record);

    int insertSelective(Attendance_status record);

    Attendance_status selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendance_status record);

    int updateByPrimaryKey(Attendance_status record);

    List<Attendance_status> selectAll();
}
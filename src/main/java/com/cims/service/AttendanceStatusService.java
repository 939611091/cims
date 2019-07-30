package com.cims.service;

import com.cims.entity.Attendance_status;


import java.util.List;

public interface AttendanceStatusService {
    //查询所有
    List<Attendance_status> selectAll();
    //删除
    int deleteByPrimaryKey(Integer id);
    //添加
    int insert(Attendance_status attendance_status);
    //根据主键查
    Attendance_status selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Attendance_status attendance_status);
}

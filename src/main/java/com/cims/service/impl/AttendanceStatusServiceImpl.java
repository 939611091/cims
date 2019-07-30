package com.cims.service.impl;

import com.cims.dao.Attendance_statusMapper;
import com.cims.entity.Attendance_status;
import com.cims.service.AttendanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceStatusServiceImpl implements AttendanceStatusService {

    @Autowired
    private Attendance_statusMapper attendance_statusMapper;

    @Override
    public List<Attendance_status> selectAll() {
        return attendance_statusMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attendance_statusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Attendance_status attendance_status) {
        return attendance_statusMapper.insert(attendance_status);
    }

    @Override
    public Attendance_status selectByPrimaryKey(Integer id) {
        return attendance_statusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Attendance_status attendance_status) {
        return attendance_statusMapper.updateByPrimaryKey(attendance_status);
    }
}

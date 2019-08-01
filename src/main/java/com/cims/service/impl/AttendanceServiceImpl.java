package com.cims.service.impl;

import com.cims.dao.Apply_payMapper;
import com.cims.dao.AttendanceMapper;
import com.cims.dao.Attendance_statusMapper;
import com.cims.dao.TeacherMapper;
import com.cims.entity.*;
import com.cims.service.AttendanceService;
import com.cims.vo.AttendanceVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private Attendance_statusMapper attendance_statusMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private Apply_payMapper apply_payMapper;

    @Override
    public PageInfo<AttendanceVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有考勤信息
        List<Attendance> attendanceList = attendanceMapper.selectByMap(map);
        //定义考勤VO列表
        List<AttendanceVo> attendanceVoList = new LinkedList<>();
        //把课程逐个转成课程VO
        for (Attendance attendance : attendanceList) {
            attendanceVoList.add(assembleAttendanceVo(attendance));
        }
        //定义返回pageInfo结果集把课程列表传进去
        PageInfo pageResult = new PageInfo(attendanceList);
        //把vo传到结果集
        pageResult.setList(attendanceVoList);
        return pageResult;
    }

    @Override
    public List<AttendanceVo> selectAll() {
        return null;
    }

    @Override
    public int insert(Attendance attendance) {
        return attendanceMapper.insert(attendance);
    }

    @Override
    public Attendance selectByPrimaryKey(Integer id) {
        return attendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Attendance attendance) {
        return attendanceMapper.updateByPrimaryKey(attendance);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return attendanceMapper.deleteByPrimaryKey(id);
    }


    private AttendanceVo assembleAttendanceVo(Attendance attendance) {
        AttendanceVo attendanceVo = new AttendanceVo();
        BeanUtils.copyProperties(attendance, attendanceVo);
        //把考勤ID查出的考勤传给attendanceVo
        Attendance_status attendance_status = attendance_statusMapper.selectByPrimaryKey(attendance.getAttendanceStatusId());
        attendanceVo.setAttendance_status(attendance_status);
        //把老师ID查出的老师实体传给attendanceVo
        Teacher teacher = teacherMapper.selectByPrimaryKey(attendance.getTeacherId());
        attendanceVo.setTeacher(teacher);
        //把报名信息传给attendanceVo
        Apply_pay apply_pay = apply_payMapper.selectByPrimaryKey(attendance.getApplyPayId());
        attendanceVo.setApply_pay(apply_pay);
        return attendanceVo;
    }
}

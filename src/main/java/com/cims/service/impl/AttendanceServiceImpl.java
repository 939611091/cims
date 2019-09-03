package com.cims.service.impl;

import com.cims.dao.*;
import com.cims.entity.*;
import com.cims.service.AttendanceService;
import com.cims.vo.AttendanceDetailsVo;
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
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<AttendanceDetailsVo> selectByTeacherId(Integer id) {
        List<Attendance> attendanceList = attendanceMapper.selectByTeacherId(id);
        List<AttendanceDetailsVo> attendanceDetailsVoList = new LinkedList<>();
        //for (循环变量类型 循环变量名称 : 要被遍历的对象) 循环体
        for (Attendance attendance : attendanceList) {
            attendanceDetailsVoList.add(assembleAttendanceDVo(attendance));
        }
        return attendanceDetailsVoList;
    }

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
    public PageInfo<AttendanceDetailsVo> selectByMap2(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有考勤信息
        List<Attendance> attendanceList = attendanceMapper.selectByMap2(map);
        //定义考勤VO列表
        List<AttendanceDetailsVo> attendanceDetailsVoList = new LinkedList<>();
        //for (循环变量类型 循环变量名称 : 要被遍历的对象) 循环体
        for (Attendance attendance : attendanceList) {
            attendanceDetailsVoList.add(assembleAttendanceDVo(attendance));
        }
        //定义返回pageInfo结果集把课程列表传进去
        PageInfo pageResult = new PageInfo(attendanceList);
        //把vo传到结果集
        pageResult.setList(attendanceDetailsVoList);
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

    @Override
    public int updateTeacherState1ById(Integer id) {
        return attendanceMapper.updateTeacherState1ById(id);
    }

    @Override
    public int updateTeacherState2ById(Integer id) {
        return attendanceMapper.updateTeacherState2ById(id);
    }

    @Override
    public int updateStudentState1ById(Integer id) {
        return attendanceMapper.updateStudentState1ById(id);
    }

    @Override
    public int updateStudentState2ById(Integer id) {
        return attendanceMapper.updateStudentState2ById(id);
    }

    @Override
    public int updateStateById(Integer id) {
        return attendanceMapper.updateStateById(id);
    }

    @Override
    public List<AttendanceDetailsVo> selectByStudentId(Integer id) {
        List<Attendance> attendanceList = attendanceMapper.selectByStudentId(id);
        List<AttendanceDetailsVo> attendanceVoList = new LinkedList<>();
        //for (循环变量类型 循环变量名称 : 要被遍历的对象) 循环体
        for (Attendance attendance : attendanceList) {
            attendanceVoList.add(assembleAttendanceDVo(attendance));
        }
        return attendanceVoList;
    }


    private AttendanceVo assembleAttendanceVo(Attendance attendance) {
        AttendanceVo attendanceVo = new AttendanceVo();
        BeanUtils.copyProperties(attendance, attendanceVo);
        //把考勤状态ID查出的考勤传给attendanceVo
        Attendance_status attendance_status = attendance_statusMapper.selectByPrimaryKey(attendance.getAttendanceStatusId());
        attendanceVo.setAttendance_status(attendance_status);
        //把老师ID查出的老师实体传给attendanceVo
        Teacher teacher = teacherMapper.selectByPrimaryKey(attendance.getTeacherId());
        attendanceVo.setTeacher(teacher);
        //把报名信息传给attendanceVo
        Apply_pay apply_pay = apply_payMapper.selectByPrimaryKey(attendance.getApplyPayId());
        attendanceVo.setApply_pay(apply_pay);
        //把学生信息传给attendanceVo
        Student student = studentMapper.selectByPrimaryKey(attendance.getStudentId());
        attendanceVo.setStudent(student);
        return attendanceVo;
    }

    private AttendanceDetailsVo assembleAttendanceDVo(Attendance attendance) {
        AttendanceDetailsVo attendanceDetailsVo = new AttendanceDetailsVo();
        BeanUtils.copyProperties(attendance, attendanceDetailsVo);
        //把考勤状态ID查出的考勤传给attendanceVo
        Attendance_status attendance_status = attendance_statusMapper.selectByPrimaryKey(attendance.getAttendanceStatusId());
        attendanceDetailsVo.setAttendance_status(attendance_status);
        //把老师ID查出的老师实体传给attendanceVo
        Teacher teacher = teacherMapper.selectByPrimaryKey(attendance.getTeacherId());
        attendanceDetailsVo.setTeacher(teacher);
        //把报名信息传给attendanceVo
        Apply_pay apply_pay = apply_payMapper.selectByPrimaryKey(attendance.getApplyPayId());
        attendanceDetailsVo.setApply_pay(apply_pay);
        //根据报名ID查课程把课程名赋给attendanceDetailsVo
        Course course = courseMapper.selectByPrimaryKey(apply_pay.getCourseId());
        attendanceDetailsVo.setCourseName(course.getcName());
        //把学生信息传给attendanceVo
        Student student = studentMapper.selectByPrimaryKey(attendance.getStudentId());
        attendanceDetailsVo.setStudent(student);
        return attendanceDetailsVo;
    }



}

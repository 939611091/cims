package com.cims.service;

import com.cims.entity.Attendance;
import com.cims.entity.Honor;
import com.cims.vo.AttendanceDetailsVo;
import com.cims.vo.AttendanceVo;
import com.cims.vo.HonorVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AttendanceService {
    /**
     * 老师端使用
     * 通过老师ID查询所有的请假信息
     * @param id
     * @return
     */
    List<AttendanceDetailsVo> selectByTeacherId(Integer id);
    PageInfo<AttendanceVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);

    /**
     * 管理员端
     * 根据学生ID查
     * @param map
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<AttendanceDetailsVo> selectByMap2(Map<String, Object> map, int pageNum, int pageSize);
    //查询全部
    List<AttendanceVo> selectAll();
    //添加
    int insert(Attendance attendance);
    //根据主键查
    Attendance selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Attendance attendance);
    //删除
    int deleteByPrimaryKey(Integer id);

    //老师已批准设为1
    int updateTeacherState1ById(Integer id);
    //老师不批准设为2
    int updateTeacherState2ById(Integer id);

    //考勤时检验学生是否到课
    //学生未到课为1
    int updateStudentState1ById(Integer id);
    //学生到课为2
    int updateStudentState2ById(Integer id);

    int updateStateById(Integer id);

    //根据学生ID查考勤记录
    List<AttendanceVo> selectByStudentId(Integer id);
}

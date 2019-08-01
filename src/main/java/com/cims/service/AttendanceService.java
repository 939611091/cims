package com.cims.service;

import com.cims.entity.Attendance;
import com.cims.entity.Honor;
import com.cims.vo.AttendanceVo;
import com.cims.vo.HonorVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AttendanceService {
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<AttendanceVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);
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
}

package com.cims.service;

import com.cims.entity.Apply_pay;
import com.cims.entity.Course;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ApplyService {
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<Apply_payVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);

    //添加
    int insert(Apply_pay apply_pay);
    //根据主键查
    Apply_pay selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Apply_pay apply_pay);
    //删除
    int deleteByPrimaryKey(Integer id);
    //考勤成功后更新apply的剩余课时
    int updateSurplusHourByCourseId(Integer id,Integer cPeriod);
    /**
     * 删除课程时根据课程ID删除对应的报名缴费信息
     */
    int deleteByCourseId(Integer id);
}

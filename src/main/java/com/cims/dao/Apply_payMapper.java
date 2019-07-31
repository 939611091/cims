package com.cims.dao;

import com.cims.entity.Apply_pay;
import com.cims.entity.Course;

import java.util.List;
import java.util.Map;

public interface Apply_payMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apply_pay record);

    int insertSelective(Apply_pay record);

    Apply_pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply_pay record);

    int updateByPrimaryKey(Apply_pay record);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Apply_pay> selectByMap(Map<String, Object> map);

    List<Apply_pay> selectByStudentId(Integer id);
}
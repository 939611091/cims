package com.cims.dao;

import com.cims.entity.Course;
import com.cims.entity.Honor;

import java.util.List;
import java.util.Map;

public interface HonorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Honor record);

    int insertSelective(Honor record);

    Honor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Honor record);

    int updateByPrimaryKey(Honor record);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Honor> selectByMap(Map<String, Object> map);
    //用于学生荣誉中心显示
    List<Honor> selectAll();

    //用于前端首页展示
    List<Honor> selectAll5();
}
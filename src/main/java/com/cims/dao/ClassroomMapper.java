package com.cims.dao;

import com.cims.entity.Classroom;

import java.util.List;

public interface ClassroomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classroom record);

    int insertSelective(Classroom record);

    Classroom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classroom record);

    int updateByPrimaryKey(Classroom record);

    List<Classroom> selectAll();
}
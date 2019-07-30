package com.cims.service;


import com.cims.entity.Classroom;

import java.util.List;

public interface ClassroomService {
    //查询所有
    List<Classroom> getAllClassroom();
    //删除
    int deleteByPrimaryKey(Integer id);
    //添加
    int insert(Classroom classroom);

    //根据主键查
    Classroom selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Classroom classroom);
}

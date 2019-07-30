package com.cims.service.impl;


import com.cims.dao.ClassroomMapper;
import com.cims.entity.Classroom;
import com.cims.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> getAllClassroom() {
        return classroomMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return classroomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Classroom classroom) {
        return classroomMapper.insert(classroom);
    }

    @Override
    public Classroom selectByPrimaryKey(Integer id) {
        return classroomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Classroom classroom) {
        return classroomMapper.updateByPrimaryKey(classroom);
    }
}

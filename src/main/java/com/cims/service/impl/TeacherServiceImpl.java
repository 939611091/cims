package com.cims.service.impl;

import com.cims.dao.TeacherMapper;
import com.cims.entity.Teacher;
import com.cims.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public Teacher login(String username, String password) {
        return teacherMapper.selectLogin(username,password);
    }
}

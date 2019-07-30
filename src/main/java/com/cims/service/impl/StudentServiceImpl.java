package com.cims.service.impl;

import com.cims.dao.StudentMapper;
import com.cims.entity.Student;
import com.cims.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student login(String username, String password) {
        return studentMapper.selectLogin(username,password);
    }
}

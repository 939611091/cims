package com.cims.service;

import com.cims.entity.Student;

public interface StudentService {
    //登录
    Student login(String username, String password);
}

package com.cims.service;

import com.cims.entity.Teacher;

public interface TeacherService {
    //登录
    Teacher login(String username, String password);
}

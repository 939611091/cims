package com.cims.service;

import com.cims.entity.Apply_pay;
import com.cims.entity.Student;
import com.cims.vo.Apply_payVo;

import java.util.List;

public interface StudentService {
    //登录
    Student login(String username, String password);
    //查出这个学生ID的所有报名缴费单
    List<Apply_payVo> selectByStudentId(Integer id);
}

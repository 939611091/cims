package com.cims.service.impl;

import com.cims.dao.StudentMapper;
import com.cims.entity.Student;
import com.cims.service.AStudentService;
import com.cims.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AStudentServiceImpl implements AStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> studentList = studentMapper.selectByMap(map);
        PageInfo pageResult = new PageInfo(studentList);
        pageResult.setList(studentList);
        return pageResult;
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int selectByUsername(String username) {
        return studentMapper.selectByUsername(username);
    }

    @Override
    public int insert(Student student) {
        //对密码进行加密
        student.setPassword(MD5Util.MD5EncodeUtf8(student.getPassword()));
        return studentMapper.insert(student);
    }

    @Override
    public Student selectByPrimaryKey(Integer studentId) {
        return studentMapper.selectByPrimaryKey(studentId);
    }

    @Override
    public int updateByPrimaryKey(Student student) {
        //对密码进行加密
        student.setPassword(MD5Util.MD5EncodeUtf8(student.getPassword()));
        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public int deleteByPrimaryKey(Integer studentId) {
        return studentMapper.deleteByPrimaryKey(studentId);
    }

    @Override
    public String selectPasswordById(Integer studentId) {
        return studentMapper.selectPasswordById(studentId);
    }


}

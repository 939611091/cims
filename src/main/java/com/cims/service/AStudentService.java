package com.cims.service;


import com.cims.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface AStudentService {
    /**
     * 分页查找 符合条件的管理员
     *
     * @param map      条件
     * @param pageNum  第几页
     * @param pageSize 页面大小
     * @return PageInfo<StudentService>
     *
     */
    PageInfo<Student> selectByMap(Map<String, Object> map, int pageNum, int pageSize);

    //根据ID查用户名
    int selectByUsername(String username);
    //添加
    int insert(Student student);
    //根据主键查
    Student selectByPrimaryKey(Integer studentId);
    //更新
    int updateByPrimaryKey(Student student);
    //删除
    int deleteByPrimaryKey(Integer studentId);
    //根据ID查密码
    String selectPasswordById(Integer studentId);
}

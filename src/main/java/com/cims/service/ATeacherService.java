package com.cims.service;

import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ATeacherService {
    /**
     * 分页查找 符合条件的管理员
     *
     * @param map      条件
     * @param pageNum  第几页
     * @param pageSize 页面大小
     * @return PageInfo<StudentService>
     *
     */
    PageInfo<Teacher> selectByMap(Map<String, Object> map, int pageNum, int pageSize);

    //根据用户名查用户
    int selectByUsername(String username);
    //添加
    int insert(Teacher teacher);
    //根据主键查
    Teacher selectByPrimaryKey(Integer teacherId);
    //更新
    int updateByPrimaryKey(Teacher teacher);
    //删除
    int deleteByPrimaryKey(Integer teacherId);
    //根据ID查密码
    String selectPasswordById(Integer teacherId);
    //查询所有--用于前端显示
    List<Teacher> selectAll();
    //用于前端首页展示
    List<Teacher> selectAll5();

}

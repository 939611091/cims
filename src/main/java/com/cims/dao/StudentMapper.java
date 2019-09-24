package com.cims.dao;

import com.cims.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    //根据ID判断该学生是否存在
    //用于报名缴费用
    int selectCountByStudentId(@Param("studentId") Integer sid);

    //用于查询学生ID
    List<Student> selectAll();

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Student> selectByMap(Map<String, Object> map);

    //根据ID查用户名
    int selectByUsername(String username);

    /**
     *
     * @param studentId
     * @return
     */
    String selectPasswordById(Integer studentId);

    //登录
    Student selectLogin(@Param("username") String username, @Param("password") String password);


}
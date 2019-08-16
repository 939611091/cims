package com.cims.dao;


import com.cims.entity.Student;
import com.cims.entity.Teacher;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    //用于前端首页展示
    List<Teacher> selectAll5();

    //用于前端教师中心展示
    List<Teacher> selectAll();

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Teacher> selectByMap(Map<String, Object> map);

    /**
     * 查询用户名是否重复
     * @param username
     * @return
     */
    int selectByUsername(String username);

    /**
     *
     * @param teacherId
     * @return
     */
    String selectPasswordById(Integer teacherId);

    //登录
    Teacher selectLogin(@Param("username") String username, @Param("password") String password);
}
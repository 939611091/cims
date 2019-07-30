package com.cims.dao;

import com.cims.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectAll();

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Admin> selectByMap(Map<String, Object> map);
    /**
     *把密码存下
     * @param adminId
     * @return
     */
    String selectPasswordById(Integer adminId);
    //查重名
    Admin selectByUsername(String username);
    //根据ID查用户名
    int selectByUsername2(String username);
    //登录
    Admin selectLogin(@Param("username") String username, @Param("password") String password);
}
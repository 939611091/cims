package com.cims.service;

import com.cims.common.ServerResponse;
import com.cims.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface AdminService {
    //查询所有管理员
    public List<Admin> getAllAdmin();
    /**
     * 分页查找 符合条件的管理员
     *
     * @param map      条件
     * @param pageNum  第几页
     * @param pageSize 页面大小
     * @return PageInfo<Admin>
     *
     */
    PageInfo<Admin> selectByMap(Map<String, Object> map, int pageNum, int pageSize);
    //删除该管理员
    int deleteByPrimaryKey(Integer adminId);
    //添加管理员
    int insert(Admin admin);
    //根据主键查管理员
    Admin selectByPrimaryKey(Integer adminId);
    //更新管理员
    int updateByPrimaryKey(Admin admin);
    //根据ID查密码
    String selectPasswordById(Integer adminId);
    //根据用户名查询
    Admin selectByUsername(String username);
    //查用户名是否重复
    int selectByUsername2(String username);
    //登录
    Admin login(String username, String password);
}

package com.cims.service.impl;


import com.cims.dao.AdminMapper;
import com.cims.entity.Admin;
import com.cims.service.AdminService;
import com.cims.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public List<Admin> getAllAdmin() {
        return adminMapper.selectAll();
    }

    @Override
    public PageInfo<Admin> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> adminList = adminMapper.selectByMap(map);
//        for (Admin admin : adminList) {
//            adminList.add(admin);
//        }
        PageInfo pageResult = new PageInfo(adminList);
        pageResult.setList(adminList);
        return pageResult;
    }

    @Override
    public int deleteByPrimaryKey(Integer adminId) {
        return 0;
    }

    @Override
    public int insert(Admin admin) {
        //对密码进行加密
        admin.setPassword(MD5Util.MD5EncodeUtf8(admin.getPassword()));
        return adminMapper.insert(admin);
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByPrimaryKey(Admin admin) {
        //对密码进行加密
        admin.setPassword(MD5Util.MD5EncodeUtf8(admin.getPassword()));
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public String selectPasswordById(Integer adminId) {
        return adminMapper.selectPasswordById(adminId);
    }

    @Override
    public Admin selectByUsername(String username) {
         return adminMapper.selectByUsername(username);
    }

    @Override
    public int selectByUsername2(String username) {
        return adminMapper.selectByUsername2(username);
    }

    @Override
    public Admin login(String username, String password) {
        //对输入的密码进行加密然后和数据库比对
        String md5Password = MD5Util.MD5EncodeUtf8(password);

        Admin admin = adminMapper.selectLogin(username,md5Password);
        if (admin != null){
            //把密码设为空，防止别人获取
            admin.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            return admin;
        }else {
            return null;
        }

    }


}

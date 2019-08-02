package com.cims.service.impl;


import com.cims.dao.AdminMapper;
import com.cims.entity.Admin;
import com.cims.service.AdminService;
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
//        admin.setPassword(MD5Util.MD5EncodeUtf8(admin.getPassword()));
//        PasswordEncoder passwordEncoder = new PasswordEncoder();
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminMapper.insert(admin);
    }

    @Override
    public Admin selectByPrimaryKey(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByPrimaryKey(Admin admin) {
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
        //密码解密
//        String md5Password = MD5Util.MD5EncodeUtf8(password);

        Admin admin = adminMapper.selectLogin(username,password);
        if (admin != null){
            //加密
//            admin.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            return admin;
        }else {
            return null;
        }
    }


}

package com.cims.service.impl;

import com.cims.dao.TeacherMapper;
import com.cims.entity.Student;
import com.cims.entity.Teacher;
import com.cims.service.ATeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ATeacherServiceImpl implements ATeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 列表服务
     *
     * @param pageNum  第几页
     * @param pageSize 每页数据大小
     * @param map      传到页面的 model
     * @return pageResult
     */
    @Override
    public PageInfo<Teacher> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> teacherList = teacherMapper.selectByMap(map);
        PageInfo pageResult = new PageInfo(teacherList);
        pageResult.setList(teacherList);
        return pageResult;
    }

    @Override
    public int selectByUsername(String username) {
        return teacherMapper.selectByUsername(username);
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer teacherId) {
        return teacherMapper.selectByPrimaryKey(teacherId);
    }

    @Override
    public int updateByPrimaryKey(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }

    @Override
    public int deleteByPrimaryKey(Integer teacherId) {
        return teacherMapper.deleteByPrimaryKey(teacherId);
    }

    @Override
    public String selectPasswordById(Integer teacherId) {
        return teacherMapper.selectPasswordById(teacherId);
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }
}

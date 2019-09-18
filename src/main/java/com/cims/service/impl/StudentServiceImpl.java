package com.cims.service.impl;

import com.cims.dao.Apply_payMapper;
import com.cims.dao.CourseMapper;
import com.cims.dao.StudentMapper;
import com.cims.entity.Apply_pay;
import com.cims.entity.Course;
import com.cims.entity.Student;
import com.cims.service.StudentService;
import com.cims.util.MD5Util;
import com.cims.vo.Apply_payVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Apply_payMapper apply_payMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student login(String username, String password) {
        //对输入的密码进行加密然后和数据库比对
        String md5Password = MD5Util.MD5EncodeUtf8(password);

        Student student = studentMapper.selectLogin(username,md5Password);
        if (student != null){
            //把密码设为空，防止别人获取
            student.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
            return student;
        }else {
            return null;
        }

    }

    @Override
    public List<Apply_payVo> selectByStudentId(Integer id) {
        List<Apply_pay> apply_payList = apply_payMapper.selectByStudentId(id);
        List<Apply_payVo> apply_payVoList = new LinkedList<>();
        for (Apply_pay apply_pay : apply_payList) {
            apply_payVoList.add(assembleApplyVo(apply_pay));
        }
        return apply_payVoList;
    }

    private Apply_payVo assembleApplyVo(Apply_pay apply_pay) {
        Apply_payVo apply_payVo = new Apply_payVo();
        BeanUtils.copyProperties(apply_pay, apply_payVo);
        //把courseid查出的course传给apply_payVo
        Course course = courseMapper.selectByPrimaryKey(apply_pay.getCourseId());
        apply_payVo.setCourse(course);
        //把学生ID查出的学生实体传给apply_payVo
        Student student = studentMapper.selectByPrimaryKey(apply_pay.getStudentId());
        apply_payVo.setStudent(student);
        return apply_payVo;
    }
}

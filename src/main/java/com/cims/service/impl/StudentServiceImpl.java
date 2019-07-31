package com.cims.service.impl;

import com.cims.dao.Apply_payMapper;
import com.cims.dao.CourseMapper;
import com.cims.dao.StudentMapper;
import com.cims.entity.Apply_pay;
import com.cims.entity.Course;
import com.cims.entity.Student;
import com.cims.service.StudentService;
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
        return studentMapper.selectLogin(username,password);
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

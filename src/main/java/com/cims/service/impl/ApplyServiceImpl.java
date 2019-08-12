package com.cims.service.impl;

import com.cims.dao.Apply_payMapper;
import com.cims.dao.CourseMapper;
import com.cims.dao.StudentMapper;
import com.cims.entity.*;
import com.cims.service.ApplyService;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private Apply_payMapper apply_payMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Apply_payVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //查出所有报名缴费
        List<Apply_pay> apply_payList = apply_payMapper.selectByMap(map);
        //定义报名缴费VO列表
        List<Apply_payVo> apply_payVoList = new LinkedList<>();
        //把报名缴费逐个转成报名缴费VO
        for (Apply_pay apply_pay : apply_payList) {
            apply_payVoList.add(assembleApplyVo(apply_pay));
        }
        //定义返回pageInfo结果集把课程列表传进去
        PageInfo pageResult = new PageInfo(apply_payList);
        //把vo传到结果集
        pageResult.setList(apply_payVoList);
        return pageResult;
    }



    @Override
    public int insert(Apply_pay apply_pay) {
        return apply_payMapper.insert(apply_pay);
    }

    @Override
    public Apply_pay selectByPrimaryKey(Integer id) {
        return apply_payMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Apply_pay apply_pay) {
        return apply_payMapper.updateByPrimaryKey(apply_pay);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return apply_payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateSurplusHourByCourseId(Integer id,Integer cPeriod) {
        return apply_payMapper.updateSurplusHourByCourseId(id,cPeriod);
    }

    @Override
    public int deleteByCourseId(Integer id) {
        return apply_payMapper.deleteByCourseId(id);
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

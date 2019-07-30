package com.cims.service.impl;

import com.cims.dao.HonorMapper;
import com.cims.entity.*;
import com.cims.service.AStudentService;
import com.cims.service.HonorService;
import com.cims.vo.HonorVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class HonorServiceImpl implements HonorService {
    @Autowired
    private HonorMapper honorMapper;
    @Autowired
    private AStudentService aStudentService;

    @Override
    public PageInfo<HonorVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<HonorVo> selectAll() {
        List<Honor> honorList = honorMapper.selectAll();
        List<HonorVo> honorVoList = new LinkedList<>();
        for (Honor honor : honorList) {
            honorVoList.add(assembleHonorVo(honor));
        }
        return honorVoList;
    }

    @Override
    public int insert(Honor honor) {
        return honorMapper.insert(honor);
    }

    @Override
    public Honor selectByPrimaryKey(Integer id) {
        return honorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Honor honor) {
        return honorMapper.updateByPrimaryKey(honor);
    }

    /**
     * Honor转换成HonorVo
     * 用 BeanUtils.copyProperties(原对象, 目标对象) 把 Honor 中的基本信息复制到 HonorVo 中
     * 通过 Course 中的 id 获取 对应ID的信息
     * @param honor
     * @return HonorVo
     */
    private HonorVo assembleHonorVo(Honor honor) {
        HonorVo honorVo = new HonorVo();
        BeanUtils.copyProperties(honor, honorVo);
        //把学生查出的student传给honorVo
        Student student = aStudentService.selectByPrimaryKey(honor.getStudentId());
        honorVo.setStudent(student);
        return honorVo;
    }
}

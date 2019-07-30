package com.cims.service;

import com.cims.entity.Course;
import com.cims.entity.Honor;
import com.cims.vo.CourseVo;
import com.cims.vo.HonorVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface HonorService {
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<HonorVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);
    //查询全部
    List<HonorVo> selectAll();
    //添加
    int insert(Honor honor);
    //根据主键查
    Honor selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Honor honor);

}

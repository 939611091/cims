package com.cims.service;

import com.cims.entity.Apply_pay;
import com.cims.entity.Course;
import com.cims.vo.Apply_payVo;
import com.cims.vo.CourseVo;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ApplyService {
    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    PageInfo<Apply_payVo> selectByMap(Map<String, Object> map, int pageNum, int pageSize);

    //添加
    int insert(Apply_pay apply_pay);
    //根据主键查
    Apply_pay selectByPrimaryKey(Integer id);
    //更新
    int updateByPrimaryKey(Apply_pay apply_pay);
    //删除
    int deleteByPrimaryKey(Integer id);
}

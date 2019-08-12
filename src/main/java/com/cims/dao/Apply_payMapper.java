package com.cims.dao;

import com.cims.entity.Apply_pay;
import com.cims.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Apply_payMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apply_pay record);

    int insertSelective(Apply_pay record);

    Apply_pay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Apply_pay record);

    int updateByPrimaryKey(Apply_pay record);

    /**
     * 通过map查询
     *
     * @param map
     * @return
     */
    List<Apply_pay> selectByMap(Map<String, Object> map);

    List<Apply_pay> selectByStudentId(Integer id);

    /**
     * 考勤用的！
     * 通过课程ID查到所有的报名单
     * @param id
     * @return
     */

    List<Apply_pay> selectByCourseId(Integer id);

    /**
     * 考勤用的，点击剩余学时-每次扣的学时
     * @param id
     * @param cPeriod
     * @return
     */
    int updateSurplusHourByCourseId(@Param("courseId")Integer id, @Param("cPeriod") Integer cPeriod);

    /**
     * 删除课程时根据课程ID删除对应的报名缴费信息
     */
    int deleteByCourseId(Integer id);
}
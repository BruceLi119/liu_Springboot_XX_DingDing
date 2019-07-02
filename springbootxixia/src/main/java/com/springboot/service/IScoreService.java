package com.springboot.service;

import com.springboot.domain.Score;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface IScoreService {

    /**
     * 根据部门Id查询出部门所有人的姓名和部门所有人的userId
     */
    public List<Map<String, String>> findUserByDeptId(int deptId);

    /**
     *根据台账日期和登录人的userId查看分数
     * @param auditUserId
     * @param month
     */
    public List<Score> findUserByMonth(String auditUserId,String month);

    /**
     * 如果是审核，则添加分数
     *
     * @param list
     */
    public void insertScore(List<Score> list);

    /**
     * 如果是复核，则更新分数
     */
    public void updateScore(List<Score> list);
}

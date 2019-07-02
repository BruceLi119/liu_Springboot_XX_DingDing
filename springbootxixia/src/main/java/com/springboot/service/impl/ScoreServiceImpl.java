package com.springboot.service.impl;

import com.springboot.dao.IScoreMapper;
import com.springboot.domain.Score;
import com.springboot.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("scoreService")
public class ScoreServiceImpl implements IScoreService {

    @Autowired
    private IScoreMapper scoreMapper;

    /**
     * 根据部门Id查询出部门所有人的姓名和部门所有人的userId
     */
    public List<Map<String, String>> findUserByDeptId(int deptId) {
        return scoreMapper.findUserByDeptId(deptId);
    }

    /**
     *根据台账日期和登录人的userId查看分数
     * @param auditUserId
     * @param month
     */
    public List<Score> findUserByMonth(String auditUserId,String month){
        return scoreMapper.findUserByMonth(auditUserId,month);
    }

    /**
     * 如果是审核，则添加分数
     *
     * @param list
     */
    public void insertScore(List<Score> list) {
        scoreMapper.insertScore(list);
    }

    /**
     * 如果是复核，则更新分数
     */
    public void updateScore(List<Score> list){
        scoreMapper.updateScore(list);
    }
}

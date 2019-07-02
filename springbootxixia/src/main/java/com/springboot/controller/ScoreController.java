package com.springboot.controller;

import com.springboot.domain.Common;
import com.springboot.domain.Score;
import com.springboot.service.IScoreService;
import com.springboot.util.DateAndStringUtils;
import com.springboot.util.DifferentDepartmentsTzUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private IScoreService scoreService;

    /**
     * 根据部门Id查询出部门所有人的姓名和部门所有人的userId
     */
    @RequestMapping("/findUserByDeptId")
    public List<Map<String, String>> findUserByDeptId(int deptId) {
        List userByDeptId = scoreService.findUserByDeptId(deptId);
        return userByDeptId;
    }

    /**
     *根据台账日期和登录人的userId查看分数
     * @param common
     */
    @RequestMapping("/findUserByMonth")
    public List<Score> findUserByMonth(@RequestBody Common common){
        //获取到月份
        String month = common.getMonth();
        //获取到登录人的Id
        String auditUserId = common.getAuditUserId();
        //将yyyy-MM格式的日期转换为yyyy年MM月格式
        String replace​Month = DateAndStringUtils.getReplace​(month);
        //获取台账列表
        List<Score> userByMonth = scoreService.findUserByMonth(auditUserId, replace​Month+"%");
        return userByMonth;
    }

    /**
     * 添加分数
     *
     * @param scoreList
     */
    @RequestMapping("/insertScore")
    public Map insertScore(@RequestBody List<Score> scoreList) {
        Map map = new HashMap();
        //返回值数据
        int code = -1;
        //返回值提示
        String msg = "";
        try {
            //插入分数信息
            scoreService.insertScore(scoreList);
            code = 0;
            msg = "审核提交成功";
        } catch (Exception e) {
            msg = "审核提交出现了一些问题，请重新审核";
        }
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    /**
     * 更新分数
     * @param scoreList
     */
     @RequestMapping("/updateScore")
     public Map updateScore(@RequestBody  List<Score> scoreList){
         Map map = new HashMap();
         //返回值数据
         int code = -1;
         //返回值提示
         String msg = "";
         try {
             //插入分数信息
             scoreService.updateScore(scoreList);
             code = 0;
             msg = "复核提交成功";
         } catch (Exception e) {
             msg = "复核提交出现了一些问题，请重新审核";
         }
         map.put("code", code);
         map.put("msg", msg);
         return map;
     }
}

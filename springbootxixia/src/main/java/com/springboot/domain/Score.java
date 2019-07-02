package com.springboot.domain;

import java.util.Date;

/**
 * 存储人员分数
 */
public class Score {
    //主键，自增
    private int id;
    //用户名
    private String userName;
    //操作此记录的用户Id
    private String auditUserId;
    //表头信息
    private String header;
    //审核的时间
    private Date auditTime;
    //部门编号
    private int deptId;
    //业务扣分项
    private int ywTerm;
    //业务扣分
    private int ywBranch;
    //连带扣分项
    private int ldTerm;
    //连带扣分
    private int ldBranch;
    //业务得分
    private int ywScore;
    //综合得分
    private int zhScore;
    //本月得分
    private int byScore;
    //考核得分
    private int khScore;
    //钱数
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getYwTerm() {
        return ywTerm;
    }

    public void setYwTerm(int ywTerm) {
        this.ywTerm = ywTerm;
    }

    public int getYwBranch() {
        return ywBranch;
    }

    public void setYwBranch(int ywBranch) {
        this.ywBranch = ywBranch;
    }

    public int getLdTerm() {
        return ldTerm;
    }

    public void setLdTerm(int ldTerm) {
        this.ldTerm = ldTerm;
    }

    public int getLdBranch() {
        return ldBranch;
    }

    public void setLdBranch(int ldBranch) {
        this.ldBranch = ldBranch;
    }

    public int getYwScore() {
        return ywScore;
    }

    public void setYwScore(int ywScore) {
        this.ywScore = ywScore;
    }

    public int getZhScore() {
        return zhScore;
    }

    public void setZhScore(int zhScore) {
        this.zhScore = zhScore;
    }

    public int getByScore() {
        return byScore;
    }

    public void setByScore(int byScore) {
        this.byScore = byScore;
    }

    public int getKhScore() {
        return khScore;
    }

    public void setKhScore(int khScore) {
        this.khScore = khScore;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

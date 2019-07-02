package com.springboot.domain;

import java.util.Date;

public class Common {
    //当前登录人的userId
    private String userId;
    //查询人的userId
    private String findUserId;
    //台账类型
    private String styleTz;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //钉钉中登录人的Id
    private String auditUserId;
    //钉钉中登录人的Id
    private String month;

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStyleTz() {
        return styleTz;
    }

    public void setStyleTz(String styleTz) {
        this.styleTz = styleTz;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFindUserId() {
        return findUserId;
    }

    public void setFindUserId(String findUserId) {
        this.findUserId = findUserId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}

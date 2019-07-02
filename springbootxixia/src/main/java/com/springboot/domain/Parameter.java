package com.springboot.domain;


import java.io.Serializable;

/**
 * 台账的实体类
 */
public class Parameter implements Serializable {
    //主键
    private int id;
    //用户的userName
    private String userName;
    //用户的userId
    private String userId;
    //台账类型
    private String styleTz;
    //书写时间
    private String writingTime;
    //完成情况
    private String completion;
    //临时任务)
    private String task;
    //接收人
    private String recipient;


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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStyleTz() {
        return styleTz;
    }

    public void setStyleTz(String styleTz) {
        this.styleTz = styleTz;
    }

    public String getWritingTime() {
        return writingTime;
    }

    public void setWritingTime(String writingTime) {
        this.writingTime = writingTime;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}

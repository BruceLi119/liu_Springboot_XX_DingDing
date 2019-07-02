package com.springboot.domain;

/**
 * 构建台账科室中的任务详情
 */
public class DepartmentsTZ {
    private int id;
    private String name;
    private String content;

    public DepartmentsTZ() {
    }

    public DepartmentsTZ(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

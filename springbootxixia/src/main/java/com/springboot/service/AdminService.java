package com.springboot.service;

import java.util.List;

public interface AdminService {
    /**
     * 查询出部门管理
     * @param name
     * @return
     */
    public List<String> findDeptIsNumOne(String name);

    /**
     * 查询部门下所有的员工姓名
     */
    public List<String> findAllNameByDeptId(int deptId);
}

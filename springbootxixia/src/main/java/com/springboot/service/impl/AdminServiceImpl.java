package com.springboot.service.impl;

import com.springboot.dao.IAdminMapper;
import com.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private IAdminMapper adminMapper;

    /**
     * 查询出部门管理
     * @param name
     * @return
     */
    public List<String> findDeptIsNumOne(String name){
        return adminMapper.findDeptIsNumOne(name);
    }

    /**
     * 查询部门下所有的员工姓名
     */
    public List<String> findAllNameByDeptId(int deptId){
        return adminMapper.findAllNameByDeptId(deptId);
    }
}

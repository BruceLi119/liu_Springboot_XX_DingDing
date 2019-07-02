package com.springboot.controller;

import com.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询出部门管理
     * @param name
     * @return
     */
    @RequestMapping("/findDeptIsNumOne")
    public List<String> findDeptIsNumOne(String name){
        List deptIsNumOne = adminService.findDeptIsNumOne(name);
        System.out.println(deptIsNumOne);
        return deptIsNumOne;
    }

    /**
     * 查询部门下所有的员工姓名
     */
    @RequestMapping("/findAllNameByDeptId")
    public List<String> findAllNameByDeptId(int deptId){
        List<String> allNameByDeptId = adminService.findAllNameByDeptId(deptId);
        System.out.println(allNameByDeptId);
        return allNameByDeptId;
    }
}

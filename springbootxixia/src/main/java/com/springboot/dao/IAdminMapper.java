package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IAdminMapper {
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

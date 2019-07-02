package com.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.service.AdminService;
import com.springboot.util.AccessTokenUtils;
import com.springboot.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限控制
 */
//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/permissions")
public class PermissionsController {

    @Autowired
    private AdminService adminService;

    @Value("${appkey}")
    private String appkey;
    @Value("${appsecret}")
    private String appsecret;

    @RequestMapping("/send")
    public String Send() throws IOException {
        String accessToken = AccessTokenUtils.getAccessToken(appkey, appsecret);
        System.out.println(accessToken);
        return accessToken;
    }

    /**
     * 根据前端传入的用户Id获取用户部门和用户岗位
     * @param userId
     * @return
     */
    @RequestMapping("/sendPermissions")
    public Map SendPermissions(String userId) throws IOException {
        Map map = new HashMap();
        //定义权限初始化值 1代表最高权限 2代表部门权限，可以查看本部门 3代表职员
        int permissions = -1;
        //定义获取用户部门和岗位的URL
        String url = "http://218.29.74.138:9010/dingding/DingDingManage/WorkLedger/UserLogin?value=" + userId;
        //调用实体类方法，并获取结果
        String content = HttpClientUtils.HttpGET(url);
        //System.out.println("content:" + content);
        //将content字符串转为JSON对象
        JSONObject jsonObject = JSON.parseObject(content);
        //根据resultData键获取对应的值
        JSONArray resultDataArray = jsonObject.getJSONArray("resultdata");
        //System.out.println("resultDataArray:" + resultDataArray);
        //获取resultData对象
        JSONObject resultData = (JSONObject) resultDataArray.get(0);
        //System.out.println("resultData:" + resultData);
        //获取RoleName(岗位名称)
        String roleName = resultData.getString("RoleName");
        //获取DeptName(部门名称)
        String deptName = resultData.getString("DeptName");
        //System.out.println("deptName:" + deptName);
        //获取PersonName(成员名称)
        String PersonName = resultData.getString("PersonName");
        //System.out.println("PersonName:" + PersonName);
        //获取DeptId(部门的ID)
        int deptId = resultData.getInteger("DeptId");
        //System.out.println("deptId:" + deptId);
        //根据此人的名字，查询出部门领导
        List deptIsNumOne = adminService.findDeptIsNumOne(PersonName);
        //System.out.println("deptIsNumOne:"+deptIsNumOne);
        if (roleName.equals("管理员") || roleName.equals("超级管理员") || roleName.equals("经理")
                || roleName.equals("副经理")) {
            permissions = 1;
        } else if (roleName.equals("科长") || roleName.equals("主任")) {
            permissions = 2;
        } else {
            permissions = 3;
        }
        List<String> allName=null;
        if (permissions==1||permissions==2){
            //根据部门Id查询部门全部人员
            allName = adminService.findAllNameByDeptId(deptId);
            //System.out.println(allName);
        }
        map.put("permissions", permissions);
        map.put("deptName", deptName);
        map.put("deptIsNumOne", deptIsNumOne);
        map.put("allName", allName);
        return map;
    }
}

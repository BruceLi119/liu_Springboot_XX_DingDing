package com.springboot.util;

import com.springboot.domain.DepartmentsTZ;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回不同科室的台账信息
 */
public class DifferentDepartmentsTzUtils {
    public static List getTz(String deptName){
        List list = new ArrayList();
        if (deptName.equals("安保科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"安全检查","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
        }else if (deptName.equals("办公室")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"文字材料","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"人资社保","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"日常事物","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"协助党团工会","");
            DepartmentsTZ departmentsTZ5 = new DepartmentsTZ(5,"创建活动","");
            DepartmentsTZ departmentsTZ6 = new DepartmentsTZ(6,"专职司机","");
            DepartmentsTZ departmentsTZ7 = new DepartmentsTZ(7,"专业学习","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
            list.add(departmentsTZ5);
            list.add(departmentsTZ6);
            list.add(departmentsTZ7);
        }else if (deptName.equals("班子成员")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"抄表收费客服","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"二次供水工程质检测绘","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"办公日常事务","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"工会安保供水稽查","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"供水稳定维修及时","");
            DepartmentsTZ departmentsTZ5 = new DepartmentsTZ(5,"工程施工安装","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
            list.add(departmentsTZ5);
        }else if (deptName.equals("财务科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"日常事务","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"财政局对接","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"住建局对接","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"国税局对接","");
            DepartmentsTZ departmentsTZ5 = new DepartmentsTZ(5,"地税局对接","");
            DepartmentsTZ departmentsTZ6 = new DepartmentsTZ(6,"产投公司对接","");
            DepartmentsTZ departmentsTZ7 = new DepartmentsTZ(7,"专业学习","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
            list.add(departmentsTZ5);
            list.add(departmentsTZ6);
            list.add(departmentsTZ7);
        }else if (deptName.equals("测绘测漏科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"测绘测漏专业学习","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
        }else if (deptName.equals("调度中心")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"管网监测","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"设备维护","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"客服","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"岗位规范","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
        }else if (deptName.equals("二供办")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"政策宣传","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"项目跟进","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"资料归档","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"后期设备维修","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
        }else if (deptName.equals("工程部")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常部门管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"施工管理科","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"技术科","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
        }else if (deptName.equals("稽查队")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"巡查","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
        }else if (deptName.equals("水厂")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"水量水压","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"设备安装维护维修","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"水质检测化验","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
        }else if (deptName.equals("维修校验科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"管道维修","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"材料管理","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"水表校验","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
        }else if (deptName.equals("巡线科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"巡线工作","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
        }else if (deptName.equals("营业科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"放卡抽查","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"数据票据","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"抄 表","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"包 片","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
        }else if (deptName.equals("质检科")){
            DepartmentsTZ departmentsTZ0 = new DepartmentsTZ(0,"日常管理","");
            DepartmentsTZ departmentsTZ1 = new DepartmentsTZ(1,"工程验收","");
            DepartmentsTZ departmentsTZ2 = new DepartmentsTZ(2,"维修质检","");
            DepartmentsTZ departmentsTZ3 = new DepartmentsTZ(3,"管材验收","");
            DepartmentsTZ departmentsTZ4 = new DepartmentsTZ(4,"工程质检","");
            DepartmentsTZ departmentsTZ5 = new DepartmentsTZ(5,"材料资料","");
            DepartmentsTZ departmentsTZ6 = new DepartmentsTZ(6,"文字材料","");
            list.add(departmentsTZ0);
            list.add(departmentsTZ1);
            list.add(departmentsTZ2);
            list.add(departmentsTZ3);
            list.add(departmentsTZ4);
            list.add(departmentsTZ5);
            list.add(departmentsTZ6);
        }else {
            String s = "暂未查询到本科室台账，请联系管理员添加";
            list.add(s);
        }
        return list;
    }
}

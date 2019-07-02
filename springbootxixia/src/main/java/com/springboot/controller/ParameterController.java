package com.springboot.controller;

import com.springboot.domain.Common;
import com.springboot.domain.Parameter;
import com.springboot.domain.Score;
import com.springboot.service.ParameterService;
import com.springboot.util.DateAndStringUtils;
import com.springboot.util.DifferentDepartmentsTzUtils;
import com.springboot.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//解决跨域问题
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    /**
     * 根据不同科室，获取不同工作详情
     */
    @RequestMapping("/get")
    public List get(String deptName) {
        List list = DifferentDepartmentsTzUtils.getTz(deptName);
        return list;
    }

    /**
     * 根据userId查询用户台账详情
     *
     * @param userId
     * @return
     */
    @RequestMapping("/findByUserId")
    public List<Parameter> findByUserId(String userId) {
        return parameterService.findByUserId(userId);
    }

    /**
     * 根据id查询台账
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public List<Parameter> findById(int id) {
        return parameterService.findById(id);
    }

    /**
     * 插入台账，不分日周月
     *
     * @param parameter
     * @return
     */
    @RequestMapping("/insertTz")
    public Map insertTz(@RequestBody Parameter parameter) {
        Map map = new HashMap();
        //设置默认值提示信息为null
        String msg = "";
        //默认状态为-1
        int code = -1;
        try {
            parameterService.insertTz(parameter);
            msg = "添加成功";
            code = 0;
        } catch (Exception e) {
            msg = "添加失败";
        }
        map.put("msg", msg);
        map.put("code", code);
        return map;
    }

    /**
     * 查询日，周，月台账的书写状态
     */
    @RequestMapping("/getStateToTz")
    public Map getStateToTz(String userId) {
        Map map = new HashMap();
        //分别定义今天、本周、本月的状态
        boolean BtodayState = false;
        boolean BweekState = false;
        boolean BmonthState = false;
        //获取当前日期
        Date today = new Date();
        //将当前日期转换为yyyy-MM-dd形式
        String todayString = DateAndStringUtils.getDate(today);
        //获取当前日期的准确时间 例如2019-06-21  得到21
        int todayStringToInt = StringUtils.getStringSplitToInt(todayString);
        //System.out.println("todayStringToInt:" + todayStringToInt);
        //获取本周第一天的日期
        Date week = DateAndStringUtils.getWeek();
        //将本周第一天日期转换为yyyy-MM-dd形式
        String weekString = DateAndStringUtils.getDate(week);
        //获取当前日期的准确时间 例如2019-06-17  得到17
        int weekStringToInt = StringUtils.getStringSplitToInt(weekString);
        //System.out.println("weekStringToInt:" + weekStringToInt);
        //获取本月第一天的日期
        Date month = DateAndStringUtils.getMonth();
        //将本月第一天日期转换为yyyy-MM-dd形式
        String monthString = DateAndStringUtils.getDate(month);
        //获取本月第一天的准确时间 例如2019-06-01  得到01
        int monthStringToInt = StringUtils.getStringSplitToInt(monthString);
        //System.out.println("monthStringToInt:" + monthStringToInt);
        //获取本月最后一天的日期
        Date monthLastDay = DateAndStringUtils.getMonthLastDay();
        //将本月最后一天日期转换为yyyy-MM-dd形式
        String monthLastDayString = DateAndStringUtils.getDate(monthLastDay);
        //获取本月最后一天的准确时间 例如2019-06-30  得到30
        int monthLastDayStringToInt = StringUtils.getStringSplitToInt(monthLastDayString);
        //System.out.println("monthLastDayStringToInt:" + monthLastDayStringToInt);
        //如果当前日期和本月日期相同
        if (todayString.equals(monthString) || monthStringToInt + 1 == todayStringToInt) {
            //获取上个月第一天的时间
            Date firstDayOfLastMonth = DateAndStringUtils.getFirstDayOfLastMonth();
            //获取到上个月第一天的台账
            List<Parameter> tzByTime = parameterService.findTzByTime(userId, firstDayOfLastMonth, today);
            for (int i = 0; i < tzByTime.size(); i++) {
                //获取到台账的创建时间
                String writingTime = tzByTime.get(i).getWritingTime();
                //获取台账对应的月份
                int dateSplitToInt = StringUtils.getDateSplitToInt(writingTime);
                //获取当前日期对应的月份
                int dateSplitToInt1 = StringUtils.getDateSplitToInt(todayString);
                if (dateSplitToInt1 == dateSplitToInt) {
                    //获取到台账的类型
                    String styleTz = tzByTime.get(i).getStyleTz();
                    //打印台账类型
                    //System.out.println(tzByTime.get(i).getStyleTz());
                    //将台账的创建时间转化为int类型，方便判断
                    int writingTimeInt = StringUtils.getStringSplitToInt(writingTime);
                    //System.out.println("writingTimeInt:" + writingTimeInt);
                    //判断各个台账的状态
                    if (styleTz.equals("dayTZ") && writingTimeInt == todayStringToInt) {
                        //更改当天状态为true
                        BtodayState = true;
                    } else if (styleTz.equals("weekTZ") && (writingTimeInt <= todayStringToInt && writingTimeInt >= weekStringToInt)) {
                        //更改本周状态为true
                        BweekState = true;
                    } else if (styleTz.equals("monthTZ") && (writingTimeInt <= todayStringToInt && writingTimeInt >= monthStringToInt)) {
                        //更改本月状态为true
                        BmonthState = true;
                    }
                }
            }
        } else {
            //查询从本月第一天到今天的全部台账
            List<Parameter> tzByTime = parameterService.findTzByTime(userId, month, today);
            for (int i = 0; i < tzByTime.size(); i++) {
                //获取到台账的类型
                String styleTz = tzByTime.get(i).getStyleTz();
                //打印台账类型
                //System.out.println(tzByTime.get(i).getStyleTz());
                //获取到台账的创建时间
                String writingTime = tzByTime.get(i).getWritingTime();
                //将台账的创建时间转化为int类型，方便判断
                int writingTimeInt = StringUtils.getStringSplitToInt(writingTime);
                //System.out.println("writingTimeInt:" + writingTimeInt);
                //判断各个台账的状态
                if (styleTz.equals("dayTZ") && writingTimeInt == todayStringToInt) {
                    //更改当天状态为true
                    BtodayState = true;
                } else if (styleTz.equals("weekTZ") && (writingTimeInt <= todayStringToInt && writingTimeInt >= weekStringToInt)) {
                    //更改本周状态为true
                    BweekState = true;
                } else if (styleTz.equals("monthTZ") && (writingTimeInt <= todayStringToInt && writingTimeInt >= monthStringToInt)) {
                    //更改本月状态为true
                    BmonthState = true;
                }
            }
        }
        //初始化台账状态
        String todayState = "";
        String weekState = "";
        String monthState = "";
        if (BtodayState) {
            todayState = "今日已上报";
        } else {
            todayState = "今日未上报";
        }
        if (BweekState) {
            weekState = "本周已上报";
        } else {
            int time = 7 - (todayStringToInt - weekStringToInt);
            weekState = "距离本周上报结束还有" + time + "天";
        }
        if (BmonthState) {
            monthState = "本月已上报";
        } else {
            int time = monthLastDayStringToInt - (todayStringToInt - monthStringToInt);
            monthState = "距离本月上报结束还有" + time + "天";
        }
        map.put("todayState", todayState);
        map.put("weekState", weekState);
        map.put("monthState", monthState);
        return map;
    }

    /**
     * 根据开始时间和结束时间查询台账信息
     *
     * @param common
     * @return
     */
    @RequestMapping("/findTzByTime")
    public List<Parameter> findTzByTime(@RequestBody Common common) {
        List<Parameter> tzByTimeAndByStyleTz = new ArrayList<>();
        //获取需要查询人的userId
        String findUserId = common.getFindUserId();
        //开始时间
        Date startTime = common.getStartTime();
        //获取到开始时间的yyyy-MM-dd格式
        String startTimeString = DateAndStringUtils.getDate(startTime);
        //获取到开始时间日期的int类型
        int stringStartTimeStringToInt = StringUtils.getStringSplitToInt(startTimeString);
        //结束时间
        Date endTime = common.getEndTime();
        //获取到结束时间的yyyy-MM-dd格式
        String endTimeString = DateAndStringUtils.getDate(endTime);
        //获取到结束时间日期的int类型
        int stringEndTimeStringToInt = StringUtils.getStringSplitToInt(endTimeString);
        if (startTimeString.equals(endTimeString) || stringStartTimeStringToInt + 1 == stringEndTimeStringToInt) {
            //获取上个月第一天的时间
            Date firstDayOfLastMonth = DateAndStringUtils.getFirstDayOfLastMonth();
            //获取到相应的台账集合
            List<Parameter> tzByTimeAndByStyleTzNew = parameterService.findTzByTime(findUserId, firstDayOfLastMonth, endTime);
            for (int i = 0; i < tzByTimeAndByStyleTzNew.size(); i++) {
                //获取到书写时间的字符串类型
                String writingTime = tzByTimeAndByStyleTzNew.get(i).getWritingTime();
                //截取到yyyy-MM-dd格式日期
                String writingTimeString = writingTime.substring(0, 10);
                //当书写时间是今天的，则添加到集合中
                if (writingTimeString.equals(startTimeString) || stringEndTimeStringToInt == stringStartTimeStringToInt + 1) {
                    //将符合条件的值，放入集合中返回
                    tzByTimeAndByStyleTz.add(tzByTimeAndByStyleTzNew.get(i));
                }
            }
        } else {
            //获取到相应的台账集合
            tzByTimeAndByStyleTz = parameterService.findTzByTime(findUserId, startTime, endTime);
        }
        return tzByTimeAndByStyleTz;
    }

    /**
     * 根据时间和台账类型查询
     *
     * @param common
     * @return
     */
    @RequestMapping("/findTzByTimeAndByStyleTz")
    public List<Parameter> findTzByTimeAndByStyleTz(@RequestBody Common common) {
        List<Parameter> tzByTimeAndByStyleTz = new ArrayList<>();
        //获取需要查询人的userId
        String findUserId = common.getFindUserId();
        //开始时间
        Date startTime = common.getStartTime();
        //获取到开始时间的yyyy-MM-dd格式
        String startTimeString = DateAndStringUtils.getDate(startTime);
        //获取到开始时间日期的int类型
        int stringStartTimeStringToInt = StringUtils.getStringSplitToInt(startTimeString);
        //结束时间
        Date endTime = common.getEndTime();
        //获取台账类型
        String styleTz = common.getStyleTz();
        //获取到结束时间的yyyy-MM-dd格式
        String endTimeString = DateAndStringUtils.getDate(endTime);
        //获取到结束时间日期的int类型
        int stringEndTimeStringToInt = StringUtils.getStringSplitToInt(endTimeString);
        if (startTimeString.equals(endTimeString) || stringStartTimeStringToInt + 1 == stringEndTimeStringToInt) {
            //获取上个月第一天的时间
            Date firstDayOfLastMonth = DateAndStringUtils.getFirstDayOfLastMonth();
            //获取到相应的台账集合
            List<Parameter> tzByTimeAndByStyleTzNew = parameterService.findTzByTimeAndByStyleTz(findUserId, styleTz, firstDayOfLastMonth, endTime);
            for (int i = 0; i < tzByTimeAndByStyleTzNew.size(); i++) {
                //获取到书写时间的字符串类型
                String writingTime = tzByTimeAndByStyleTzNew.get(i).getWritingTime();
                String writingTimeString = writingTime.substring(0, 10);
                //当书写时间是今天的，则添加到集合中
                if (writingTimeString.equals(startTimeString) || (stringStartTimeStringToInt + 1 == stringEndTimeStringToInt)) {
                    //将符合条件的值，放入集合中返回
                    tzByTimeAndByStyleTz.add(tzByTimeAndByStyleTzNew.get(i));
                }
            }
        } else {
            //获取到相应的台账集合
            tzByTimeAndByStyleTz = parameterService.findTzByTimeAndByStyleTz(findUserId, styleTz, startTime, endTime);
        }
        return tzByTimeAndByStyleTz;
    }
}

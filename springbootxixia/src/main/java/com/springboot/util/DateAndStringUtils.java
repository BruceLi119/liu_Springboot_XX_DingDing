package com.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndStringUtils {

    /**
     * 将yyyy-MM格式转换为yyyy年MM月格式
     *
     * @param month
     * @return
     */
    public static String getReplace​(String month) {
        String[] split = month.split("-");
        String ss = split[0]+"年"+split[1]+"月";
        return ss;
    }

    /**
     * 将date类型数据转换为yyyy-MM-dd HH:mm E类型的字符串
     *
     * @param date
     * @return
     */
    public static String getDateAndHourAndWeek(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm E").format(date);
    }

    /**
     * 将date类型数据转换为yyyy-MM-dd-E类型的字符串
     *
     * @param date
     * @return
     */
    public static String getDateAndWeek(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd-E").format(date);
    }

    /**
     * 将date类型数据转换为yyyy-MM-dd类型的字符串
     *
     * @param date
     * @return
     */
    public static String getDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    //本周的第一天
    public static Date getWeek() {
        Calendar curStartCal = Calendar.getInstance();
        Calendar cal = (Calendar) curStartCal.clone();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        //获取到本周的第一天
        Date time = cal.getTime();
        return time;
    }

    //本月的第一天
    public static Date getMonth() {
        Calendar curStartCal = Calendar.getInstance();
        Calendar cal2 = (Calendar) curStartCal.clone();
        cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMinimum(Calendar.DAY_OF_MONTH));
        //获取到本月的第一天
        Date time = cal2.getTime();
        return time;
    }

    //本月的最后一天
    public static Date getMonthLastDay() {
        Calendar curStartCal = Calendar.getInstance();
        Calendar cal2 = (Calendar) curStartCal.clone();
        cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time = cal2.getTime();
        return time;
    }

    //上月的第一天
    public static Date getFirstDayOfLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        //System.out.println(getDate(time));
        return time;
    }
}

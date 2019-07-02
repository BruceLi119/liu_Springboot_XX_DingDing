package com.springboot.util;

import java.util.Date;

public class StringUtils {
    /**
     * 获取当天日期代表的int值
     *
     * @param date
     * @return
     */
    public static int getStringSplitToInt(String date) {
        //截取前面的完整日期
        String substring = date.substring(0, 10);
        //分割得到年 月 日的各个值
        String[] split = substring.split("-");
        //将string的值转为int
        int i = Integer.valueOf(split[2]).intValue();
        return i;
    }


    /**
     * 获取当月日期代表的int值
     *
     * @param date
     * @return
     */
    public static int getDateSplitToInt(String date) {
        //截取前面的完整日期
        String substring = date.substring(0, 10);
        //分割得到年 月 日的各个值
        String[] split = substring.split("-");
        //将string的值转为int
        int i = Integer.valueOf(split[1]).intValue();
        return i;
    }
}

package com.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class AccessTokenUtils {
    /**
     * 获取模块的AccessToken
     * @param appkey
     * @param appsecret
     * @return
     */
    public static String getAccessToken(String appkey, String appsecret) throws IOException {
        //拼接请求路径
        String url = "https://oapi.dingtalk.com/gettoken?appkey="+appkey+"&appsecret="+appsecret;
        //获取得到的结果
        String content = HttpClientUtils.HttpGET(url);
        System.out.println(content);
        //将content字符串转为JSON对象
        JSONObject jsonObject = JSON.parseObject(content);
        //得到access_token
        String access_token = jsonObject.getString("access_token");
        return access_token;
    }
}

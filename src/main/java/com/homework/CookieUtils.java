package com.homework;

import jakarta.servlet.http.Cookie;

/**
 * cookie工具类
 * 给定cookie数组和需要查找的name
 * return：null name不存在
 *         value name对应的value
 */
public class CookieUtils {
    public static String getValueByName(Cookie[] cookies,String name){
        if (cookies ==null||name==null||"".equals(name)||cookies.length==0){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName()))
                return cookie.getValue();
        }
        return null;
    }
}

package com.chl.util;

import java.util.Random;

/**
 * @description: 字符串工具类
 * @author: mqxu
 * @create: 2020-12-05 20:40
 **/
public class StringUtil {
    private final static int LENGTH = 6;

    /**
     * 获取六位随机数短信验证码
     *
     * @return String
     */
    public static String getVerifyCode() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}

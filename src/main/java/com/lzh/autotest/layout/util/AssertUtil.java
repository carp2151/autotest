package com.lzh.autotest.layout.util;


import org.testng.Assert;

/**
 * Date: 2018-01-20-17:05
 * Created By lzh.
 * 关于testNG断言的封装
 */

public class AssertUtil {

    /**
     * 判断两个字符串是否相同
     *
     * @param actual 实际的
     * @param expected 期望的
     * @param message 提示消息
     */
    public static void assertEquals(String actual, String expected, String message){
        Assert.assertEquals(actual.trim(),expected,message);
    }


}

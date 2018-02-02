package com.lzh.autotest.test.data;

import org.testng.annotations.DataProvider;

/**
 * Date: 2018-01-21-15:49
 * Created By lzh.
 */

public class LoginDataProvider {

    @DataProvider
    public static Object[][] urlToTitle() {
        return new Object[][] {
                {"http://www.baidu.com","百度"},
                {"https://www.mi.com","小米"},
        };
    }

    @DataProvider
    public static Object[][] userAndPassword(){
        return new Object[][]{
                {"13250813191", "Happy1023"},
                {"13250813191", "Happy!023"}
        };
    }
}

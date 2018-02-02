package com.lzh.autotest.test;

import com.lzh.autotest.layout.business.LoginBusiness;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Date: 2018-01-20-14:56
 * Created By lzh.
 */
public class LoginTest extends BaseTest {

    private LoginBusiness loginBusiness;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public LoginTest(){
        loginBusiness = new LoginBusiness(webDriver);
    }

    @Test(description = "登录慕课网")
    public void loginSuccess(){
        loginBusiness.getLogin();
        loginBusiness.loginSuccess();
        loginBusiness.checkLogin();
    }

    @Test
    public void testCase(){
        System.out.println("1212");
        log.error("-----------------------------");
    }
}

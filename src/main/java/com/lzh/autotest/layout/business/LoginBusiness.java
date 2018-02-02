package com.lzh.autotest.layout.business;

import com.lzh.autotest.layout.page.LoginPage;
import com.lzh.autotest.layout.util.AssertUtil;
import com.lzh.autotest.layout.util.ProUtil;
import com.lzh.autotest.layout.util.SeleniumUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

/**
 * Date: 2018-01-23-12:58
 * Created By lzh.
 */
@Slf4j
public class LoginBusiness {

    private LoginPage loginPage;
    private SeleniumUtil seleniumUtil;

    public LoginBusiness(WebDriver driver){
        loginPage = new LoginPage(driver);
        seleniumUtil = new SeleniumUtil(driver);

    }

    /**
     * 输入用户名个密码登录
     */
    public void loginSuccess(){
        seleniumUtil.waitElementByCss("[name='emai']",5);
        loginPage.userInput().click();
        loginPage.userInput().sendKeys(ProUtil.userName());
        log.info("输入用户名"+ProUtil.userName());
        loginPage.passwordInput().click();
        loginPage.passwordInput().sendKeys(ProUtil.password());
        loginPage.entryButton().click();
        seleniumUtil.sleep(3000);
    }

    /**
     * 首页调起登录弹框
     */
    public void getLogin(){
        loginPage.loginButton().click();
        seleniumUtil.sleep(2000);
        // seleniumUtil.takeScreenShot();
    }

    /**
     * 检查用户头像判断登录是否成功
     */
    public void checkLogin(){
        if(loginPage.userImage()!=null){
            seleniumUtil.mouseOver(loginPage.userImage());
        }
        AssertUtil.assertEquals(loginPage.nickName().getText(),"拖延症的理想主义者","用户昵称不对应");
    }
}

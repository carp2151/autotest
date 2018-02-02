package com.lzh.autotest.layout.page;

import com.lzh.autotest.layout.util.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Date: 2018-01-23-11:38
 * Created By lzh.
 */

public class LoginPage extends BasePage {

    private ElementUtil elementUtil;

    public LoginPage(WebDriver webDriver) {
        elementUtil = new ElementUtil(webDriver);
    }

    /**
     * 主页登录button
     */
    public WebElement loginButton(){
        return elementUtil.element("id","js-signin-btn");
    }

    /**
     * 用户名输入框
     */
    public WebElement userInput(){
        return elementUtil.element("name","email");
    }

    /**
     * 密码输入框
     */
    public WebElement passwordInput(){
        return elementUtil.element("name","password");
    }

    /**
     * 登录按钮
     */
    public WebElement entryButton(){
        return elementUtil.element("class","xa-login");
    }

    /**
     * 首页用户头像
     */
    public WebElement userImage(){
        return elementUtil.element("class", "user-card-item");
    }

    /**
     * 首页用户昵称
     */
    public WebElement nickName(){
        return elementUtil.element("class", "name");
    }

}

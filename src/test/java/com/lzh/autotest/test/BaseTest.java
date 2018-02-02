package com.lzh.autotest.test;

import com.lzh.autotest.layout.util.SeleniumUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Date: 2018-01-20-14:56
 * Created By lzh.
 */

public class BaseTest {

    public SeleniumUtil seleniumUtil;
    public WebDriver webDriver;

    public BaseTest(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
        webDriver = new FirefoxDriver();
        seleniumUtil = new SeleniumUtil(webDriver);
    }

    @BeforeSuite
    public void setUp(){
        seleniumUtil.startUrlAndFullScreen("https://www.imooc.com/");
    }


    @AfterSuite
    public void tearDown(){
        seleniumUtil.sleep(3000);
        webDriver.quit();
        System.out.println("--------------------------");
        System.out.println("关闭浏览器，退出进程");
        System.out.println("--------------------------");
    }
}

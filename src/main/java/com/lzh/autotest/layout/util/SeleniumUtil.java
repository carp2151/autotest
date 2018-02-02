package com.lzh.autotest.layout.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Date: 2018-01-20-15:31
 * Created By lzh.
 */
@Slf4j
public class SeleniumUtil {

    private WebDriver webDriver;

    /**
     * 在构造方法webDriver入参，传入供SeleniumUtil使用的driver
     * @param webDriver webDriver
     */
    public SeleniumUtil(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     * 访问指定url
     * @param url String
     */
    public void startUrl(String url){
        webDriver.get(url);
        System.out.println("浏览器成功访问指定url："+url);
    }

    /**
     * 全屏访问指定url
     * @param url String
     */
    public void startUrlAndFullScreen(String url){
        webDriver.manage().window().maximize();
        webDriver.get(url);
        System.out.println("浏览器全屏成功访问指定url："+url);
    }

    /**
     * 关闭浏览器
     */
    public void closeBrowser(){
        webDriver.quit();
        System.out.println("成功关闭浏览器");
    }

    /**
     * 线程等待固定时间，单位：毫秒
     * @param millis int
     */
    public void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装鼠标悬停事件
     */
    public void mouseOver(WebElement element){
        if (element!=null){
            new Actions(webDriver).moveToElement(element).perform();
        }else {
            System.out.println("元素未找到！！！");
        }

    }

    /**
     * 封装截图事件
     */
    public void takeScreenShot(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
        String currStr = simpleDateFormat.format(new Date());
        //指定了OutputType.FILE做为参数传递给getScreenshotAs()方法，其含义是将截取的屏幕以文件形式返回。
        File srcFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件对象。
        try {
            FileUtils.copyFile(srcFile, new File(String.format("image\\result\\%s.png", currStr)));
            log.info("截图成功，图片保存路径为："+System.getProperty("user.dir")+String.format("\\image\\result\\%s.png", currStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待标题加载
     *
     * @param title url网页标题
     * @param timeout 超时时间
     */
    public void waitTitle(String title, int timeout){
        new WebDriverWait(webDriver,timeout).until(ExpectedConditions.titleContains(title));
    }

    /**
     * css选择器等待元素是否加载出来
     *
     * @param selector css选择器
     * @param timeout 超时时间
     */
    public void waitElementByCss(String selector,int timeout){
        new WebDriverWait(webDriver,timeout).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }








}

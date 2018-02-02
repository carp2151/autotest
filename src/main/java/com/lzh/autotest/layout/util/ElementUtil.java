package com.lzh.autotest.layout.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Date: 2018-01-23-11:39
 * Created By lzh.
 */

public class ElementUtil {

    private WebDriver webDriver;

    public ElementUtil(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public WebElement element(String type, String value){
        if(type.contains("id")){
            return webDriver.findElement(By.id(value));
        }else if (type.contains("class")){
            return webDriver.findElement(By.className(value));
        }else if(type.contains("name")){
            return webDriver.findElement(By.name(value));
        }else if(type.contains("xpath")){
            return webDriver.findElement(By.xpath(value));
        }else if (type.contains("css")){
            return webDriver.findElement(By.cssSelector(value));
        }else {
            System.out.println(type+"是不支持的方法");
            return null;
        }
    }
}

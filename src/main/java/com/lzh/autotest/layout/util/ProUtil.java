package com.lzh.autotest.layout.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Date: 2018-01-20-14:59
 * Created By lzh.
 */
@Slf4j
public class ProUtil {

    private Properties properties;
    private String filePath;

    /**
     * 构造方法处理配置文件的地址
     */
    private ProUtil(){
        String projectPath = System.getProperty("user.dir");
        filePath = projectPath + "\\src\\main\\resources\\autotest.properties";
        properties = new Properties();
    }

    /**
     * 读取配置文件
     */
    private Properties readPropertiesFile(){
        try{
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(in);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return properties;
    }

    /**
     * 根据key获取value
     */
    public static String getArg(String key){
        Properties properties = new ProUtil().readPropertiesFile();
        if(properties.containsKey(key)){
            return properties.getProperty(key);
        }
        System.out.println("!---配置文件中没有找到该字段："+key+" ---!");
        return null;
    }

    /**
     * 用户名
     * @return username
     */
    public static String userName(){
        Properties properties = new ProUtil().readPropertiesFile();
        return properties.getProperty("username");
    }

    /**
     * 获取密码
     */
    public static String password(){
        Properties properties = new ProUtil().readPropertiesFile();
        return properties.getProperty("password");
    }

}

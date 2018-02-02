package com.lzh.autotest.layout;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 2018-01-20-14:55
 * Created By lzh.
 */
@Slf4j
public class Layout {

    public static void main(String[] args) {



        // 自定义log4j配置文件的路径


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_hhmmss");
        String currStr = simpleDateFormat.format(new Date());
        System.out.println(currStr);
    }

}

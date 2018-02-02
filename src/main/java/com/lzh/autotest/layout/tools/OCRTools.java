package com.lzh.autotest.layout.tools;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Date: 2018-01-24-16:14
 * Created By lzh.
 */

public class OCRTools {

    /**
     * 百度ocr接口参数
     */
    private static final String APP_ID = "10715857";
    private static final String API_KEY = "3YVFDdrrilpwwqGw5bxcWGbn";
    private static final String SECRET_KEY = "DzULU6Mfd8ySOp1uUoLBgi0s4isuuil3";

    public static String getValue(String image){
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        JSONObject res = client.basicGeneral(image, new HashMap<String, String>());
        System.out.println((String[]) res.get("words_result"));

        return null;
    }

    public static void main(String[] args) {
        OCRTools.getValue("1.PNG");
    }
}

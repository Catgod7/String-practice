package com.hsbc.analytics.filetesting;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

/**
 * @author : Fiker_Y_B_WANG
 * @version : [v1.0]
 * @clsssName : Stringtest
 * @date : [2024/7/16 18:37]
 * @description:
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println(numberParseToStr("asda12323.00"));
        System.out.println(numberParseToStr("asda12323.012"));
    }

    public static String numberParseToStr(String str) {
        if (StringUtils.isEmpty(str)) {
            System.out.println("参数为空");
            return null;
        }
        String strNumber = str.replaceAll("[a-z|A-Z]", "");
        if (strNumber.length() == 0) {
            return "参数去除字母后，没有数字";
        }
        Float aFloat = Float.valueOf(strNumber);
        DecimalFormat format = new DecimalFormat("#.00");
        String s = format.format(aFloat);
        System.out.println(s);
        return s;
    }
}

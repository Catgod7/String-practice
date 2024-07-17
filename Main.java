package com;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(extractNumber("abcd123"));
        System.out.println(extractNumber("abcd123.4"));
        System.out.println(extractNumber("abcd123.40"));
        System.out.println(extractNumber("abcd123.4567"));
        System.out.println(extractNumber("abcd123.45267"));
        System.out.println(extractNumber("abcd"));
    }

    public static String extractNumber(String str) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher match = pattern.matcher(str);
        if (match.find()) {
            return new BigDecimal(match.group()).setScale(2, RoundingMode.DOWN).toString();
        }
        return "No digital found";
    }
}

package com.hsbc.test;

import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        new MyApplication().codePerformance(next);
    }

    private void codePerformance(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                stringBuilder.append(c);
            }
        }
        text = stringBuilder.toString();
        if (text.isEmpty()) {
            text = "0.00";
        } else {
            String[] split = text.split("\\.");
            if (split.length == 1) {
                text = text + ".00";
            } else {
                text = split[0] + "." + split[1].substring(0, 2);
            }
        }
        System.out.println(text);
    }
}
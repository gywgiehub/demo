package com.demo.gyw.java;

import java.util.Calendar;

/**
 * @Author GouYaoWen
 * @Description 普通测试类
 * @Date Create in 16:55 2019/11/26
 */
public class Test {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println("测试" +
                "😄");
        System.out.println("✔");
        System.out.println("✖");
    }
}


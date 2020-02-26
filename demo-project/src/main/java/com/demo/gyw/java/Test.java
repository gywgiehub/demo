package com.demo.gyw.java;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Vector;

/**
 * @Author GouYaoWen
 * @Description 普通测试类
 * @Date Create in 16:55 2019/11/26
 */
public class Test {
    public static void main(String[] args) {
        Vector vector;
        HashMap<String,String> map = Maps.newHashMap();
        String name = "";
        a:
        for (int i = 0; i < 10; i ++ ) {
            System.out.println(i);
            break a;
        }

        name.length();

    }

    public void test() {

    }

    public static String test(int i) {
        return "";
    }
}


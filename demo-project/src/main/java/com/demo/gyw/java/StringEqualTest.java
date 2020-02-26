package com.demo.gyw.java;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.RateLimiter;
import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.List;

@Logger
class StringEqualTest {
    public static void main(String[] args) {
       /* String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s7 = s3 + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);               //false
        System.out.println(s1 == s5);               //true
        System.out.println(s1 == s6);              //false
        System.out.println(s1 == s6.intern());     //true
        System.out.println(s2 == s2.intern());    //false
        System.out.println(s1 == s7);    //false*/

        /*RateLimiter rateLimiter = RateLimiter.create(30);
        for (int i = 0; i < 31; i++) {
            System.out.println((i+1) + ":" +rateLimiter.acquire(5));
        }*/

        List<String> list = Lists.newArrayList("1","2");
        list.stream().peek(item -> {
            System.out.println(item);
        });
        
        list.stream().forEach(item->System.out.println(item));
    }
}
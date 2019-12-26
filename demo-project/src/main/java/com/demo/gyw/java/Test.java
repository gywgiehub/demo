package com.demo.gyw.java;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.stream.Collectors;

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

        List<String> list = Lists.newArrayList("a","b","c","d");
        List<String> aList = list.stream().map(item -> {
            if(item == "a"){
                return item;
            }
            return null;
        }).filter(item->item != null).collect(Collectors.toList());
        System.out.println("找到需要到值并过滤: "+aList.toString());

        //mapList
        List<Map<String, Object>> mapList = Lists.newArrayList();
        mapList.add(Maps.newHashMap());
    }
}


package com.demo.gyw.main;

import java.util.Map;

public class UploadDemo{
    public static void main(String[] args) throws Exception {
        testLinkedHashMap();
    }

    public static void print(Map<String,Object> map) {
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }
    public static void testLinkedHashMap() {
        int cacheSize = 3;
        LRU lru = new LRU<String,Object>(cacheSize);
        lru.put("key1", "1");
        lru.put("key2", "2");
        lru.put("key3", "3");
        lru.print();

        lru.put("key4", "4");
        System.out.println("大于最大缓存是移除最先进去的");
        lru.print();
        lru.put("key5", "5");
        lru.print();

        Object o =lru.get("key3");
        System.out.println(o.toString());
        System.out.println("访问一次就将该元素移动为末端节点，即相当于最后进去的");
        lru.print();

        lru.put("key6", "6");
        lru.print();
    }
}

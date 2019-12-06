package com.demo.gyw.api;

public class TestLru {

    public static void main(String[] args) throws Exception {
        testLru();
    }

    private static void testLru() {
        LruCache lruCache = new LruCache(3);
        lruCache.put("key1", "1");
        lruCache.put("key2", "2");
        lruCache.put("key3", "3");
        System.out.println(lruCache.toString());
        lruCache.put("key4", "4");
        System.out.println(lruCache.toString());
        lruCache.get("key3");
        System.out.println(lruCache.toString());
        lruCache.remove("key4");
        System.out.println(lruCache.toString());
        lruCache.put("key5", "5");
        System.out.println(lruCache.toString());
    }
}
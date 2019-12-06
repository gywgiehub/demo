package com.demo.gyw.java.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @Description:    基于LinkHash  LRU算法
 * LRU（Least recently used，最近最少使用）
 * 算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。
 * 1. 新数据插入到链表头部；
 * 2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部；
 * 3. 当链表满的时候，将链表尾部的数据丢弃。
 * @Author:         gyw
 * @CreateDate:     9:25
 * @Version:        1.0
 */
public class LRU<K,V> {

    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K,V> map;
    private int cacheSize;

    public LRU(int cacheSize) {
        //数组缓存大小，即
        this.cacheSize = cacheSize;
        //负载因子-loadFactor = 0.75(默认) --当数组大于数组初始大小的75%后，进行扩容默认16；即12后扩容
        int capacity = (int)Math.ceil(cacheSize / hashLoadFactory) + 1;
        //accessOrder = false(默认)--true后每次访问一个元素，就将该元素所在的Node变成最后一个节点(使他成为不是最老的那个)
        map = new LinkedHashMap<K,V>(capacity, hashLoadFactory, true){
            private static final long serialVersionUID = 1;
            //是否移除该map中最老的键和值
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                //大于cacheSize移除
                return size() > LRU.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
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



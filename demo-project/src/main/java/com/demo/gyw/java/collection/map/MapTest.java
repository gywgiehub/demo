package com.demo.gyw.java.collection.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author GouYaoWen
 * @Description Map
 * 键值对
 * @Date Create in 14:29 2019/11/21
 */
public class MapTest {
    public static void main(String[] args) {
        hashMapMethod();
        treeMapMethod();
        linkedHashMapMethod();
    }

    /**
     * HashMap-数组+链表+红黑树-->size>8使用红黑树
     * 默认16 负载因子0.75 即是超过12就扩容一倍，再散列(均匀分布速度更快)
     */
    public static void hashMapMethod() {
        Map<String,String> hashMap = Maps.newHashMap();
        System.out.print("HashMap=======>");
        hashMap.put("剑魔", "独孤求败");
        hashMap.put("剑神", "西门吹雪");
        hashMap.put("剑圣", "叶孤城");
        hashMap.put("剑神2", "谢晓峰");
        hashMap.put("剑神3", "燕南天");
        hashMap.put("剑圣2", "独孤剑");
        for (Map.Entry<String ,String> entry:hashMap.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue());
            System.out.print(",");
        }
        System.out.println("");
        System.out.println("----------------------------------------");
    }

    /**
     * TreeMap-红黑树
     * 有序，不能为null--可以自定义顺序
     */
    public static void treeMapMethod() {
        Map<String,String> treeMap = Maps.newTreeMap();
        System.out.print("TreeMap(有序)=======>");
        treeMap.put("剑魔", "独孤求败");
        treeMap.put("剑神", "西门吹雪");
        treeMap.put("剑圣", "叶孤城");
        treeMap.put("剑神2", "谢晓峰");
        treeMap.put("剑神3", "燕南天");
        treeMap.put("剑圣2", "独孤剑");
        for (Map.Entry<String ,String> entry:treeMap.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue());
            System.out.print(",");
        }

        System.out.println("");
        System.out.println("----------------------------------------");
    }

    /**
     * LinkedHashMap-双向链表
     * 有序-插入顺序
     */
    public static void linkedHashMapMethod() {
        Map<String,String> linkedHashMap = Maps.newLinkedHashMap();
        System.out.print("LinkedHashMap(添加顺序)=======>");
        linkedHashMap.put("剑魔", "独孤求败");
        linkedHashMap.put("剑神", "西门吹雪");
        linkedHashMap.put("剑圣", "叶孤城");
        linkedHashMap.put("剑神2", "谢晓峰");
        linkedHashMap.put("剑神3", "燕南天");
        linkedHashMap.put("剑圣2", "独孤剑");
        for (Map.Entry<String ,String> entry:linkedHashMap.entrySet()){
            System.out.print(entry.getKey()+":"+entry.getValue());
            System.out.print(",");
        }

        System.out.println("");
        System.out.println("----------------------------------------");
    }

    /**
     * HashTable 线程安全
     */
    public static void hashTableMethod() {

    }

    /**
     * ConcurrentHashMap
     * 1.7 锁分段技术  分成几段HashTable,
     * 1.8 HashMap + CAS算法 + Synchronized同步 粒度->每个元素
     */
    public static void concurrentHashMapMethod() {

    }
}

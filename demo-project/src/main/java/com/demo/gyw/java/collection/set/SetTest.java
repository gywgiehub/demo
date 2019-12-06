package com.demo.gyw.java.collection.set;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Author GouYaoWen
 * @Description Set
 * 无序容器、不允许重复对象(包括null)
 * @Date Create in 11:15 2019/11/21
 */

public class SetTest {
    public static void main(String[] args) {
        hashSetMethod();
        treeSetMethod();
        likedHashSetMethod();
    }

    /**
     * HashSet--底层是hashMap哈希
     * 无序
     * HashSet可以接受null值，有且只有一个
     */
    public static void hashSetMethod() {
        Set hashSet = Sets.newHashSet("D","C","B","A");
        System.out.println("hashSet:"+hashSet.toString());
    }

    /**
     * LinkedHashSet--底层是LinkedHashMap
     * 有序-->插入顺序
     */
    public static void likedHashSetMethod() {
        Set linkedHashSet = Sets.newLinkedHashSet();
        linkedHashSet.add("D");
        linkedHashSet.add("C");
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        System.out.println("(添加顺序)linkedHashSet:"+linkedHashSet.toString());
    }

    /**
     * TreeSet--底层是TreeMap(红黑树)
     * 有序-->自动排序
     * 通过equals方法或者compareTo方法进行内容的比较。
     * 不能为null
     */
    public static void treeSetMethod() {
        Set treeSet = Sets.newTreeSet();
        treeSet.add("D");
        treeSet.add("C");
        treeSet.add("B");
        treeSet.add("A");
        System.out.println("(自定义顺序或者默认顺序)treeSet:"+treeSet.toString());
    }
}

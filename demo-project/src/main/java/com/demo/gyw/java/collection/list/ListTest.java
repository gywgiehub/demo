package com.demo.gyw.java.collection.list;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @Author GouYaoWen
 * @Description List
 * 有序容器、可重复对象(包括null)
 * @Date Create in 14:32 2019/11/20
 */
public class ListTest {
    public static void main(String[] args) {
        arrayListMethod();
        linkedListMethod();
        vectorMethod();
    }

    /**
     * ArrayList-容量为10
     * 基于数组
     * 随机访问get和set速度较快
     * 扩容-->增长原来1.5倍
     */
    public static void arrayListMethod() {
        List<String> arrayList = Lists.newArrayList("arrayListOne","arrayListTwo");
        System.out.println(arrayList.toString());
        System.out.println("get(0):--->"+arrayList.get(0));
    }

    /**
     * LinkedList
     * 基于链表
     * 新增和删除操作add和remove速度较快
     */
    public static void linkedListMethod() {
        List<String> linkedList = Lists.newLinkedList();
        linkedList.add("linkedListOne");
        linkedList.add("linkedListTwo");
        System.out.println(linkedList.toString());

        linkedList.remove(0);
        System.out.println("remove(0):--->"+linkedList.toString());
    }

    /**
     * Vector
     * 基于数组
     * 线程安全Synchronized
     * 扩容-->增长原来2倍
     */
    public static void vectorMethod() {
        List<String> vectorList = new Vector<>();
        vectorList.add("vectorOne");
        vectorList.add("vectorTwo");
        System.out.println(vectorList.toString());
    }
}

package com.demo.gyw.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Test4 {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        Boolean b = atomicInteger.compareAndSet(1, 2);
        System.out.println(b);
        System.out.println(atomicInteger.get());
    }

    public static void tergoods() {

    }
}

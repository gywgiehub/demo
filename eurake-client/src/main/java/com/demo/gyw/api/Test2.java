package com.demo.gyw.api;

import java.util.*;

public class Test2 {
    LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>(5, 0.75F, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Object> entry) {
            return size()>5;
        }
    };
    public static void main(String[] args) {
        //有序集合
        //int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //int value = binary(a, 9);
        //System.out.println("值位置:"+value);
        //System.out.println("值："+a[value]);
        int size = 10;
        int result = size <<= 2;
        System.out.println(result);
    }
    public static int binary(int[] array, int value)
    {
        int low = 0;
        int high = array.length - 1;
        while(low <= high)
        {
            int middle = (low + high) / 2;
            System.out.println("middle:"+middle);
            if(value == array[middle])
            {
                return middle;
            }
            if(value > array[middle])
            {
                low = middle + 1;
                System.out.println("low:"+low);
            }
            if(value < array[middle])
            {
                high = middle - 1;
                System.out.println("high:"+high);
            }
        }
        return -1;
    }

}



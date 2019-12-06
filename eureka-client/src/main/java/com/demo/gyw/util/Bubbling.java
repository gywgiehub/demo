package com.demo.gyw.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @Description:    冒泡排序
* @Author:         gyw
* @CreateDate:     2019/6/11 10:36
* @Version:        1.0
*/
public class Bubbling {

    public static int[] array = new int[]{1,7,8,0,3,2,5};

    public static void main(String[] args) {
        System.out.println("原始数据" + Arrays.toString(array));
        System.out.println("冒泡排序之后：" + Arrays.toString(bubbling()));
        List<String> list = new ArrayList<>();
        list.stream().sorted();

    }

    /**
     * 冒泡排序
     * @return
     */
    public static int[] bubbling() {
        int size = 7;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i-1; j++) {
                if (array[j] < array[j+1]) {
                    int a = array[j];
                    array[j] = array[j+1];
                    array[j+1] = a;
                }
            }
            System.out.println("第" + (i + 1) + "波排序后：" + Arrays.toString(array));
        }
        return array;
    }
}

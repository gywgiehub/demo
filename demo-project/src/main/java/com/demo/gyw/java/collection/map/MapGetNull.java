package com.demo.gyw.java.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    当map.get(key) key值不存在
* @Author:         gyw
* @CreateDate:     2019/11/6 11:41
* @Version:        1.0
*/
public class MapGetNull {

    public static void main(String[] args) {
        Map<Long, Long> map = new HashMap<>();
        map.put(1L, 1L);

        System.out.println("存在该key："+map.get(1L));
        System.out.println("不存在该key："+map.get(2L));
    }
}

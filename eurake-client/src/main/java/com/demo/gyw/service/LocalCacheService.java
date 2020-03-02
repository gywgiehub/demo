package com.demo.gyw.service;

import com.demo.gyw.base.Demo;

import java.util.concurrent.ExecutionException;

/**
* @Description:    本地缓存存储
* @Author:         gyw
* @CreateDate:     2019/5/28 15:30
* @Version:        1.0
*/
public interface LocalCacheService {
    /**
     * 通过Id获取Demo属性
     * @param key
     * @return
     */
    Demo getDemo(String key) throws ExecutionException;
}

package com.demo.gyw.service.impl;

import com.demo.gyw.base.Demo;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.demo.gyw.repository.DemoRepository;
import com.demo.gyw.service.LocalCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
* @Description:    本地缓存实现
* @Author:         gyw
* @CreateDate:     2019/5/28 15:31
* @Version:        1.0
*/
@Service
public class LocalCacheServiceImpl implements LocalCacheService {

    @Autowired
    private DemoRepository repository;

    private LoadingCache<String, Demo> demoLoadingCache = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .build(new CacheLoader<String, Demo>() {
                @Override
                public Demo load(String key) throws Exception {
                    //查询数据库
                    Demo entity = new Demo();
                    entity.setId(1L);
                    entity.setAge(18);
                    entity.setCode("001");
                    entity.setName("张三");
                    return entity;
                }
            });
    /**
     * 获取Demo对象-->先从缓存中拿，没有就去查询数据库
     * @return
     */
    @Override
    public Demo getDemo(String key) throws ExecutionException {
        return demoLoadingCache.get(key);
    }
}

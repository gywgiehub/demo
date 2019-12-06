package com.demo.gyw.service;
/**
* @Description:    Redis测试接口
* @Author:         gyw
* @CreateDate:     2019/5/27 10:36
* @Version:        1.0
*/
public interface RedisTestService {

    default String get() {
        return "JDK8接口可以有默认实现-default";
    }
}

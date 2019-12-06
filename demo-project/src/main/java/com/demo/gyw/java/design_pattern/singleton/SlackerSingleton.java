package com.demo.gyw.java.design_pattern.singleton;

import java.util.Objects;

/**
* @Description:    懒汉单例
 *  懒汉模式在使用时，容易引起不同步问题，所有应该创建同步锁
* @Author:         gyw
* @CreateDate:     2019/11/5 11:41
* @Version:        1.0
*/
public class SlackerSingleton {
    //私有静态类
    private static SlackerSingleton instance = null;

    /**
     * 私有构造方法
     */
    private SlackerSingleton() {

    }

    /**
     * 公共静态获取类对象方法
     * @return
     */
    public static SlackerSingleton getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SlackerSingleton();
        }
        return instance;
    }
}

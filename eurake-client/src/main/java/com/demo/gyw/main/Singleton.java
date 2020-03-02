package com.demo.gyw.main;

import java.util.Objects;

/**
* @Description:    java类作用描述
* @Author:         gyw
* @CreateDate:     2019/6/4 17:45
* @Version:        1.0
*/
public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getSingleton(Singleton singleton) {
        if (Objects.isNull(singleton)) {
            synchronized (Singleton.class) {
                if (Objects.isNull(singleton)) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

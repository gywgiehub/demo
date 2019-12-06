package com.demo.gyw.util;

import java.util.Objects;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if(Objects.isNull(singleton)){
            synchronized (Singleton.class) {
                if(Objects.isNull(singleton)){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

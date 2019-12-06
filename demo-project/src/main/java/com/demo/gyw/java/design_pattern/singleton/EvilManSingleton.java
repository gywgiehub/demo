package com.demo.gyw.java.design_pattern.singleton;
/**
* @Description:    恶汉单例
* @Author:         gyw
* @CreateDate:     2019/11/5 11:38
* @Version:        1.0
*/
public class EvilManSingleton {

    private static EvilManSingleton instance = new EvilManSingleton();

    private EvilManSingleton() {
    }

    public static EvilManSingleton getInstance() {
        return instance;
    }
}

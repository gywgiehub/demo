package com.demo.gyw.java.design_pattern.singleton;

import java.util.Objects;

/**
* @Description:    双重判断懒汉单例
* @Author:         gyw
* @CreateDate:     2019/11/5 11:48
* @Version:        1.0
*/
public class JudgeIfSingleton {
    /**
     * 私有静态实例 防止被引用，此处赋值为null，目的是实现延迟加载
     */
    private static JudgeIfSingleton instance = null;

    /**
     * 私有构造方法，防止被实例化
     */
    private JudgeIfSingleton() {

    }

    /**
     * 公共静态
     * @return
     */
    public static JudgeIfSingleton getInstance() {
        //先检查实例是否存在，如果不存在才进入下面的同步块
        if (Objects.isNull(instance)) {
            //同步块，线程安全地创建实例
            synchronized (JudgeIfSingleton.class) {
                if (Objects.isNull(instance)) {
                    instance = new JudgeIfSingleton();
                }
            }
        }
        return instance;
    }
}







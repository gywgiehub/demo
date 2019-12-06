package com.demo.gyw.java.abstract_and_interface;

/**
 * @Author GouYaoWen
 * @Description 接口
 * 全是public abstract->抽象方法
 * 没有方法体
 * 只能有常量-> static final
 * @Date Create in 11:31 2019/11/26
 */
public interface InterfaceTest {
    /**
     * 静态常量
     * public static
     */
    String name = "静态常量！";

    /**
     * 抽象方法
     * public abstract
     */
    void abstractInterFaceMethod();
}

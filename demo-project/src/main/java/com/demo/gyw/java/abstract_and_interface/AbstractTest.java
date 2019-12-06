package com.demo.gyw.java.abstract_and_interface;

/**
 * @Author GouYaoWen
 * @Description 抽象类
 * 不能实例化
 * 可以有
 * 普通属性和静态属性
 * 普通方法和静态方法
 * 非抽象方法
 * 方法体
 * 构造器
 * 任意修饰符
 * @Date Create in 15:53 2019/11/25
 */
public abstract class AbstractTest {
    /**
     * 构造器
     */
    public AbstractTest() {
        System.out.println("构造器！");
    }
    /**
     * 普通属性
     */
    private String name;
    protected String name2;
    String name3;
    private String name4;
    /**
     * 静态属性
     */
    private static String staticName;
    /**
     * 普通方法
     */
    public void ordinaryMethod() {
        System.out.println("普通方法！");
    }
    /**
     * 静态方法
     */
    public static void staticMethod() {
        System.out.println("静态方法！");
    }
    /**
     * 抽象方法
     */
    public abstract void abstractClassMethod();
    /**
     * protected修饰方法
     */
    protected void protectedMethod() {
        System.out.println("protected修饰方法！");
    }
    /**
     * default修饰方法
     */
    void defaultMethod() {
        System.out.println("default修饰方法！");
    }
    /**
     * private修饰方法
     */
    private void privateMethod() {
        System.out.println("private修饰方法！");
    }
    /**
     * main方法
     * @param args
     */
    public static void main(String[] args) {
    }
}

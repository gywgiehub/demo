package com.demo.gyw.java.design_pattern;

/**
 * @Description:    类适配器模式
 * @Author:         gyw
 * @CreateDate:     2019/10/31 15:26
 * @Version:        1.0
 */
public class ClassAdapter {
    public static void main(String[] args){
        Adapter adapt = new Adapter();
        adapt.method1();
        adapt.method2();
    }
}

interface TargetInterface {
    /**
     * 方法一
     */
    void method1();

    /**
     * 方法二
     */
    void method2();
}
/**
 *  源类，我们需要这个类实现接口  TargetInterface，但这个类不能被改变
 *  源类与接口之间是没有关系的
 */
class BeAdapted{
    /**
     * 用户名
     */
    private String name;
    public void method1(){
        System.out.println("method1");
    }

    @Override
    public String toString() {
        return "BeAdapted{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * 这是适配器，它接受了BeAdapted中已有的接口并产生我们需要的接口
 * method1()方法继承自BeAdapted类（即已有的接口），不用再作声明
 * -----这里适配器的作用相当于为源类与接口之间建立了一种关系，类似于 implements
 */
class Adapter extends BeAdapted implements TargetInterface{
    /**
     * method2()方法无法通过继承获得，因而需要自己声明，这就是适配器为我们产生的接口
     */
    @Override
    public void method2(){
        System.out.println("child method2");
    }
}

package com.demo.gyw.java.multi_thread.create;

/**
 * @Description: 创建多线程之继承Thread
 * @Author: gyw
 * @CreateDate: 2019/11/5 11:15
 * @Version: 1.0
 */
public class ExtendThread extends Thread {

    private String name;

    public ExtendThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }


    public static void main(String[] args) {
        //创建线程
        ExtendThread threadOne = new ExtendThread("线程-one");
        ExtendThread threadTwo = new ExtendThread("线程-two");
        ExtendThread threadThree = new ExtendThread("线程-three");
        //开启线程
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}

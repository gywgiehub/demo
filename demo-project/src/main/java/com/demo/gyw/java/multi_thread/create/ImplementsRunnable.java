package com.demo.gyw.java.multi_thread.create;
/**
* @Description:    创建多线程之实现Runnable
* @Author:         gyw
* @CreateDate:     2019/11/5 11:20
* @Version:        1.0
*/
public class ImplementsRunnable implements Runnable {

    private String name;

    public ImplementsRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        //创建真实线程对象
        ImplementsRunnable implementsOne = new ImplementsRunnable("线程-one");
        ImplementsRunnable implementsTwo = new ImplementsRunnable("线程-two");
        ImplementsRunnable implementsThree = new ImplementsRunnable("线程-three");
        //创建代理线程对象，并引用真实对象
        Thread threadOne = new Thread(implementsOne);
        Thread threadTwo = new Thread(implementsTwo);
        Thread threadThree = new Thread(implementsThree);
        //开启线程
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}

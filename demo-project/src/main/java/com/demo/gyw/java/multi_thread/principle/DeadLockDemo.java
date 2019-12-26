package com.demo.gyw.java.multi_thread.principle;

/**
 * @Author GouYaoWen
 * @Description 线程死锁
 * 产生死锁必须具备以下四个条件：
     * 互斥条件：该资源任意一个时刻只由一个线程占用。
     * 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
     * 不剥夺条件:线程已获得的资源在末使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
     * 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 * @Date Create in 10:17 2019/12/24
 */
public class DeadLockDemo {
    private static Object resourceOne = "资源One";//资源One
    private static Object resourceTwo = "资源Two";//资源Two

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始时间" + System.currentTimeMillis());
            synchronized (resourceOne) {
                System.out.println(Thread.currentThread().getName() + "获取资源One");
                try {
                    //resourceOne.wait();释放锁其他资源可以继续抢锁，该资源等待被唤醒，重新抢锁；
                    //resourceOne.wait(1000); 释放锁，等待1000毫秒后可以重新抢锁；
                    //Thread.sleep(1000); 不释放锁，等待1000毫秒后继续执行该资源；
                    resourceOne.wait(1000);
                    //Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "等待resourceTwo释放！");
                synchronized (resourceTwo) {
                    System.out.println(Thread.currentThread().getName() + "等到了释放获取资源Two");
                }
            }
        },"线程One").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始时间" + System.currentTimeMillis());
            synchronized (resourceTwo) {
                System.out.println(Thread.currentThread().getName() + "获取资源Two");
                try {
                    resourceTwo.wait(1000);
                    //Thread.sleep(1000);//休眠1000毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "等待resourceOne释放！");
                //资源One同步方法
                synchronized (resourceOne) {
                    System.out.println(Thread.currentThread().getName() + "等到了释放获取资源One");
                }
            }
        },"线程Two").start();
    }
}
/*outPut:
        线程One开始时间1577156537228
        线程Two开始时间1577156537228
        线程One获取资源One
        线程Two获取资源Two
        线程Two等待resourceOne释放！
        线程One等待resourceTwo释放！*/

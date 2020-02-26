package com.demo.gyw.java.multi_thread.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author GouYaoWen
 * @Description 线程池
 * @Date Create in 13:17 2020/2/14
 */
public class ThreadPool {

    public static void main(String[] args) {
        /**
         * 提示让手动创建线程池
         */
        //创建一个单线程的线程池，此线程池保证所有任务的执行顺序按照任务的提交顺序执行
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        //创建固定大小的线程池，每次提交一个任务就创建一个线程，直到线程到达线程池的最大大小
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        //创建一个可缓存的线程池，此线程池不会对线程池的大小做限制，线程池大小完全依赖于JVM能够创建的最大线程大小
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //创建一个大小无限的线程池，此线程池支持定时以及周期性执行任务的需求
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        /**
         * 手动创建线程池
         */
        //创建线程工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("xxx-pool-%d")
                .build();
        //创建通用线程池
        /**
         * 参数含义
         *      corePoolSize：线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态。
         *      maximumPoolSize：线程池中所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小
         *                       的LinkedBlockingDeque时，这个值无效。
         *      keepAliveTime：当线程数量多于corePoolSize(核心线程数)时，空闲线程的存活时长，超过这个时间就会被回收。
         *      unit：keepAliveTime(空闲线程存活时间)的时间单位。
         *      workQueue：存放待处理任务的队列，该队列只接受Runnable接口。常用的有三种队列，SynchronousQueue(直接握手队列),
         *                 LinkedBlockingDeque(无界队列),ArrayBlockingQueue(有界队列)。
         *      threadFactory：线程创建工厂。
         *      handler：当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution
         *               方法，参考ThreadPoolExecutor类中的内部策略类。
         */
        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                200,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
                );
        for (int i = 0; i < 1000; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}

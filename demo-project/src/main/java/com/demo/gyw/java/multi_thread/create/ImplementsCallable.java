package com.demo.gyw.java.multi_thread.create;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
* @Description:    创建多线程之实现Callable
* @Author:         gyw
* @CreateDate:     2019/11/5 11:26
* @Version:        1.0
*/
public class ImplementsCallable implements Callable<String> {

    private String name;

    public ImplementsCallable(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println(this.name);
        return this.name;
    }

    public static void main(String[] args) {
        //固定大小线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //创建线程
        List<ImplementsCallable> list = new ArrayList<>();
        list.add(new ImplementsCallable("线程-one"));
        list.add(new ImplementsCallable("线程-two"));
        list.add(new ImplementsCallable("线程-three"));
        //调用线程
        try {
            List<Future<String>> futures = executorService.invokeAll(list);
            for (Future<String> future : futures) {
                //获取call方法的返回值
                System.out.println("call()返回值："+future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

package com.demo.gyw.java.distributed;

class ThreadA extends Thread {
    private JedisPoolExecutor jedisPoolExecutor;
 
    public ThreadA(JedisPoolExecutor jedisPoolExecutor) {
        this.jedisPoolExecutor = jedisPoolExecutor;
    }
 
    @Override
    public void run() {
        jedisPoolExecutor.seckill();
    }
}

/**
 * @Author GouYaoWen
 * @Description
 * @Date Create in 14:33 2020/2/18
 **/
public class DistributedLockTest {
    public static void main(String[] args) {
        JedisPoolExecutor jedisPool = new JedisPoolExecutor();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(jedisPool);
            threadA.start();
        }
    }
}
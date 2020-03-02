package com.demo.gyw.service.impl;

import com.demo.gyw.service.RedisTestService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
* @Description:    Redis测试实现
* @Author:         gyw
* @CreateDate:     2019/5/27 10:36
* @Version:        1.0
*/
public class RedisTestServiceImpl implements RedisTestService {

    /**
     * 非切片额客户端链接
     */
    private Jedis jedis;

    /**
     * 非切片连接池(单机)
     */
    private static JedisPool jedisPool;

    /**
     * 切片额客户端连接
     */
    private ShardedJedis shardedJedis;

    /**
     * 切片连接池(集群)
     */
    private ShardedJedisPool shardedJedisPool;

    public static void main(String[] args) {

    }
}

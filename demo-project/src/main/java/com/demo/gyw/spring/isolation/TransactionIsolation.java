package com.demo.gyw.spring.isolation;

import org.springframework.transaction.annotation.*;

/**
 * @Author GouYaoWen
 * @Description 事务隔离级别
 * 脏读：一个事务读取到了另一个事务未提交的数据
 * //一个事务读取到了另一个事务回滚前的脏数据，即是另一个事务修改后回滚了，A事务读取到回滚前的数据
 * 不可重复读：一个事务读取到了另一个事务已经提交的update数据导致多次查询结果不一致
 * //先读取一条数据，再次读取发现另一个事务将这条数据改变了
 * 幻读：一个事务读取到另一个事务已经提交的insert的数据导致多次查询结果不一致
 * //先读取N条数据，再次读取发现另一个事务插入了一条新数据，两次结果一致
 * @Date Create in 9:32 2019/12/3
 */
public class TransactionIsolation {

    /**
     * 默认-->default
     * Mysql默认采用不可重复读(repeatable_read)
     * Oracle默认采用已提交读(read_committed)
     */
    @Transactional(isolation = Isolation.DEFAULT)
    public void defaultIsolation() {
        System.out.println("默认！");
    }

    /**
     * 未提交读-->read_uncommitted
     * 脏读   不可重复读   幻读   都有可能发生
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void readUncommitted() {
        System.out.println("未提交读！");
    }

    /**
     * 已提交读-->read_committed
     * 不可重复读   幻读  有可能发生
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommitted() {
        System.out.println("已提交读！");
    }

    /**
     * 可重复读-->repeatable_read
     * 幻读   有可能发生
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void repeatableRead() {
        System.out.println("可重复读取！");
    }

    /**
     * 串行化-->serializable
     * 避免所有读问题  速度较慢
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void serializable() {
        System.out.println("串行化！");
    }
}

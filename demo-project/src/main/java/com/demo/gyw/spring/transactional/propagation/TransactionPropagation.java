package com.demo.gyw.spring.transactional.propagation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author GouYaoWen
 * @Description 事务传播行为
 * @Date Create in 11:35 2019/12/10
 */
public class TransactionPropagation {
    /**
     * 如果当前存在事务则加入该事务，没有就新建一个事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {

    }

    /**
     * 默认事务传播行为
     * 如果当前存在事务则加入该事务，没有则以非事务方式运行
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void propagationSupports() {

    }

    /**
     * 如果当前存在事务则加入该事务，没有则抛出异常
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void PropagationMandatory() {

    }

    /**
     * 如果当前存在事务则把事务挂起，没有新建一个事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void PropagationRequiredsNew() {

    }

    /**
     * 如果当前存在事务则把事务挂起，没有则以非事务方式运行
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void PropagationNotSupported() {

    }

    /**
     * 如果当前存在事务则抛出异常，没有则以非事务方式运行
     */
    @Transactional(propagation = Propagation.NEVER)
    public void PropagationNever() {

    }

    /**
     * 如果当前存在事务则创建一个新事物作为当前事务的嵌套事务运行
     * 没有新建一个事务
     */
    @Transactional(propagation = Propagation.NESTED)
    public void PropagationNested() {

    }
}

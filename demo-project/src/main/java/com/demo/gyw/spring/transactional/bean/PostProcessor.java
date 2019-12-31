package com.demo.gyw.spring.transactional.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 所有bean初始化前后操作
 * 单例方式注入
 * @Author GouYaoWen
 * @Description
 * @Date Create in 11:20 2019/12/31
**/
public class PostProcessor implements BeanPostProcessor {

    /**
     * bean初始化前操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("beanLifeCycle")){
            System.out.println(String.format("初始化之前:%s",beanName));
        }
        return bean;
    }

    /**
     * bean初始化后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override  
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if(beanName.equals("beanLifeCycle")){
            System.out.println(String.format("初始化之后:%s",beanName));
        }
        return bean;
    }
}
package com.demo.gyw.spring.transactional.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author GouYaoWen
 * @Description 注入需要的Bean--交给Spring管理默认单例
 * @Date Create in 16:51 2019/12/27
 */
@Configuration
public class BeanConfig {

    /**
     * 初始化前后
     * @return
     */
    @Bean
    public PostProcessor postProcessor() {
        return new PostProcessor();
    }
    /**
     * 注入BeanLifeCycle
     * bean的名字是方法名称
     * @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
     * initMethod-自定义初始化方法
     * destroyMethod-自定义销毁方法
     * @return
     */
    @Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
    public BeanLifeCycle beanLifeCycle() {
        return new BeanLifeCycle();
    }
}

package com.demo.gyw.spring.transactional.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author GouYaoWen
 * @Description bean生命周期
 * 1、实例化Bean
 * 2、依赖注入(设置属性)
 * 3、注入Aware接口
     * 实现 BeanNameAware接口----->获得到容器中Bean的名称
     *
 * 4、BeanPostProcessor初始化前后;
    * 实现 BeanPostProcessor接口 前置处理 后置处理
    * 所有的bean进行一个初始化之前和之后的代理。
 * 5、InitializingBean bean正式构造完成前(没办法处理对象本身，只能增加一些额外的逻辑);
    * 首先如果Bean 实现了InitializingBean接口，Spring将调用他们的afterPropertiesSet()方法。(不推荐)
    * 然后如果bean使用init-method声明了初始化方法，该方法也会被调用(推荐)
 * 6、DisposableBean 在bean销毁前执行指定的逻辑。
    * 首先如果bean实现了DisposableBean接口，Spring将调用它的destroy()接口方法。(不推荐)
    * 然后同样，如果bean使用了destroy-method 声明销毁方法，该方法也会被调用。(推荐)
 * //推荐不实现InitializingBean, DisposableBean接口，采用自定义方法，降低耦合度。
 * @Date Create in 16:12 2019/12/27
 */
public class BeanLifeCycle implements BeanNameAware, InitializingBean, DisposableBean {

    /**
     * 对象属性
     */
    public String objectAttribute = "对象属性";

    /**
     * BeanNameAware
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println(String.format("bean的名称:%s", s));
    }

    /**
     * InitializingBean
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean正式构造完成前(初始化)处理");
    }

    /**
     * inti-method
     * 自定义初始化方法
     */
    public void initMethod() {
        System.out.println("自定义初始化方法-bean正式构造完成前处理");
    }

    /**
     * DisposableBean
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("销毁前处理");
    }

    public void destroyMethod() {
        System.out.println("自定义方法-销毁前处理");
    }
}
/*
outPut:
        bean的名称:beanLifeCycle
        初始化之前:beanLifeCycle
        bean正式构造完成前(初始化)处理
        自定义初始化方法-bean正式构造完成前处理
        初始化之后:beanLifeCycle
        销毁前处理
        自定义方法-销毁前处理*/

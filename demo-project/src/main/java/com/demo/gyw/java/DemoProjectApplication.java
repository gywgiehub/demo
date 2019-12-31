package com.demo.gyw.java;

import com.demo.gyw.spring.aop.LogAop;
import com.demo.gyw.spring.transactional.bean.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans(value = {
        @ComponentScan(basePackageClasses= LogAop.class),
        @ComponentScan(basePackageClasses= BeanConfig.class),
})//面向切面类扫描
@EnableEurekaClient
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }
}

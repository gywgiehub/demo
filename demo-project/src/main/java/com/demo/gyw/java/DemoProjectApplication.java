package com.demo.gyw.java;

import com.demo.gyw.java.spring.aop.LogAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScans(value = { @ComponentScan(basePackageClasses= LogAop.class)})//面向切面类扫描
@EnableEurekaClient
@RestController
public class DemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }
}

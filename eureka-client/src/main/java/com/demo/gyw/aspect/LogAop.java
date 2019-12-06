package com.demo.gyw.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
* @Description:    AOP
* @Author:         gyw
* @CreateDate:     2019/6/12 17:38
* @Version:        1.0
*/
@Aspect
@Component
public class LogAop {
    @Pointcut(value="execution(* com.yizhiyixing.service.impl.*.*(..))")
    public void point(){
        System.out.println("point()");
    }

    @Before(value="point()")
    public void before(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        System.out.println(Arrays.toString(objects));
        System.out.println("before begin");
    }

    @After(value = "point()")
    public void after(JoinPoint joinPoint){
        System.out.println("after begin");
    }

    @AfterReturning(value = "point()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("afterReturning begin");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around begin");
        joinPoint.proceed();
        System.out.println("around commit");
    }
}

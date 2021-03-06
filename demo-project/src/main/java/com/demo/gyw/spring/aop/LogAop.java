package com.demo.gyw.spring.aop;

import com.demo.gyw.java.custom_annotation.LogAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author GouYaoWen
 * @Description 日志切面
 * @Pointcut 切入点-->那些要使用AOP
 * 连接点(JoinPoint)： 就是能够作为切点的一个个动作（方法），,即那些方法要用Aop。
 * 切点(Poincut)：链接点中的一个或多个，切面会在这些点上来做文章（切点就是什么地方）。当然实际上不是所有连接点都当做切点的，即匹配的连接点
 * 通知(Advice)：通知是在切点上什么时候，做什么。通知有下列几种类型：Before，After，After-returning，After-throwing，Around
 * 切面(Aspect)：切面包括切点和切面（什么时候，什么地方，做什么）。
 *
 * @Before 前置通知(Before Advice)
 * @AfterReturning 返回之后通知(After Retuning Advice):
 * @AfterThrowing 抛出（异常）后执行通知(After Throwing Advice):
 * @After 后置通知(After Advice):
 * @Around 围绕通知(Around Advice):
 * @Date Create in 10:37 2019/12/3
**/
@Component//把类交给spring管理
@Aspect//面向切面
public class LogAop{
    /**
     * 切入点
     * 扫描那些
     */
    @Pointcut(value="@annotation(com.demo.gyw.java.custom_annotation.LogAnnotation)")
    public void point(){
        System.out.println("point()");
    }

    @Before(value="point()")
    public void before(JoinPoint point){
        System.out.println("Before begin!");
        //获取方法
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        //方法
        boolean isExist = method.isAnnotationPresent(LogAnnotation.class);
        if (isExist) {
            LogAnnotation u = method.getAnnotation(LogAnnotation.class);
            System.out.println("作者:" + u.author());
            System.out.println("描述:" + u.desc());
        }else{
            System.out.println("方法"+method.getName()+"不存在该注解！");
        }
    }

    @AfterThrowing("point()")
    public void afterThrowing(){
        System.out.println("afterThrowing 异常！");
    }

    @After(value = "point()")
    public void after(){
        System.out.println("after commit!");
    }

    @AfterReturning(value = "point()")
    public void afterReturning(){
        System.out.println("AfterReturning commit!");
    }

    @Around("point()")
    public String around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("around begin!");
        Object obj = joinPoint.proceed();
        System.out.println("around commit!");
        return obj.toString();
    }
}
//SpringBoot中添加@ComponentScans(value = { @ComponentScan(basePackageClasses= LogAop.class)})
/*顺序
around begin!
Before begin!
作者:gyw
描述:欢迎
around commit!
after commit!
AfterReturning commit!*/

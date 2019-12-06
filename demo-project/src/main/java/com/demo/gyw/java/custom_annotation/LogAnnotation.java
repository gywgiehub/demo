package com.demo.gyw.java.custom_annotation;

import java.lang.annotation.*;

/**
 * @Author GouYaoWen
 * @Description 日志注解
 * @Date Create in 10:52 2019/12/3
 */
@Target({
        ElementType.METHOD
})//注解作用域(类)
@Retention(RetentionPolicy.RUNTIME)//注解生命周期(运行时存在,可以通过反射读取)
@Documented //生存JavaDoc时会包含注解
public @interface LogAnnotation {
    String value() default "";
}

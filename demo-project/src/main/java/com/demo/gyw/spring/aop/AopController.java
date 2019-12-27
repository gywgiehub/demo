package com.demo.gyw.spring.aop;

import com.demo.gyw.java.custom_annotation.LogAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GouYaoWen
 * @Description 测试控制器
 * @Date Create in 10:47 2019/12/3
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @RequestMapping("/logAnnotation")
    @LogAnnotation(author = "gyw",desc = "欢迎")//日志注解
    public String welcome() {
        return "欢迎您使用Aop测试工具!";
    }

    @RequestMapping("/throwLogAnnotation")
    @LogAnnotation(author = "gyw",desc = "异常欢迎")//日志注解
    public void throwWelcome() {
        throw new ArithmeticException("这是一个异常！");
    }
}

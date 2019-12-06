package com.demo.gyw.java.spring.aop;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @Author GouYaoWen
 * @Description 面向切面编程---->将与业务无关，却为业务模块所共同调用的逻辑或责任封装起来
 * 基于动态代理
 * 减少重复代码，降低模块耦合度，利于可扩展性和可维护性
 * @Date Create in 10:06 2019/12/3
 */
public class SpringAop {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("事务处理");
        list.add("日志管理");
        list.add("Authentication 权限管理");
        list.add("Lazy loading 懒加载");
        list.add("Error handling 错误处理");
        list.add("安全管理");
        for (String use : list) {
            System.out.println(use);
        }
    }
}

package com.demo.gyw.java.custom_annotation;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
* @Description:    自定义注解
* @Author:         gyw
* @CreateDate:     2019/10/31 16:04
* @Version:        1.0
*/
public class AnnotationTest {
    public AnnotationTest() {

    }
    public static void main(String[] args) {
        //使用类加载器加载类
        Class t = AnnotationClass.class;
        //找到上面的注解
        boolean IsExist = t.isAnnotationPresent(CustomAnnotation.class);
        if (IsExist) {
            //拿到注解实例，解析类上面的注解
            CustomAnnotation u = (CustomAnnotation) t.getAnnotation(CustomAnnotation.class);
            System.out.println("作者:" + u.author());
            System.out.println("描述:" + u.desc());
        }else{
            System.out.println("类"+t.getName()+"不存在该注解！");
        }
        //获取所有的方法
        Method[] methods = t.getMethods();
        //遍历所有的方法
        for (Method method : methods) {
            boolean isExist = method.isAnnotationPresent(CustomAnnotation.class);
            if (isExist) {
                CustomAnnotation u = method.getAnnotation(CustomAnnotation.class);
                System.out.println("作者:" + u.author());
                System.out.println("描述:" + u.desc());
            }else{
                System.out.println("方法"+method.getName()+"不存在该注解！");
            }
        }
        //获取所有属性
        Field[] fields = t.getDeclaredFields();
        for (Field field : fields) {
            boolean isExist = field.isAnnotationPresent(CustomAnnotation2.class);
            if (isExist) {
                CustomAnnotation2 customAnnotation2 = field.getAnnotation(CustomAnnotation2.class);
                System.out.println("属性名：" + customAnnotation2.name());
                System.out.println("属性值：" + customAnnotation2.value());
            }
        }
    }
}

/**
 * 注解类
 */
@CustomAnnotation(desc = "I am class annotation",author = "gyw")
@Data
class AnnotationClass {
    @CustomAnnotation2(name = "用户名",value = "张三")
    private String name;

    public AnnotationClass() { }

    @CustomAnnotation(desc = "I am method annotation",author = "gyw")
    public void TestAnnotation() { }
}

/**
 * 自定义注解
 */
@Target({
        ElementType.METHOD,
        ElementType.TYPE
})//注解作用域(方法/类)
@Retention(RetentionPolicy.RUNTIME)//注解生命周期(运行时存在,可以通过反射读取)
@Inherited//运行子注解继承
@Documented//生存JavaDoc时会包含注解
@interface CustomAnnotation {
    String desc();

    String author();

    int age() default 18;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@interface CustomAnnotation2 {
    String name();

    String value();
}
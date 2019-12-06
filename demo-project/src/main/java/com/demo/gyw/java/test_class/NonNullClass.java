package com.demo.gyw.java.test_class;

import java.util.Objects;

/**
* @Description:    new类是否是空
* @Author:         gyw
* @CreateDate:     2019/11/5 16:48
* @Version:        1.0
*/
public class NonNullClass {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        NonNullClass entity = new NonNullClass();
        if (Objects.nonNull(entity)) {
            System.out.println("new NonNullClass()不为空!");
        }else{
            System.out.println("new NonNullClass()为空!");
        }
    }
}

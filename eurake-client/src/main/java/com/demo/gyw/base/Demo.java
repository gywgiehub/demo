package com.demo.gyw.base;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
* @Description:    事例类
* @Author:         gyw
* @CreateDate:     2019/5/27 13:55
* @Version:        1.0
*/
@Entity
@Table(name = "tb_demo")
public class Demo {

    private Long id;

    private String name;

    private String code;

    private Integer age;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Demo demo = (Demo) o;
        return Objects.equals(name, demo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

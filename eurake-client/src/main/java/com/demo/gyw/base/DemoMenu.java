package com.demo.gyw.base;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
* @Description:    事例类
* @Author:         gyw
* @CreateDate:     2019/5/27 13:55
* @Version:        1.0
*/
@Entity
@Table(name = "tb_demo_menu")
@Data
public class DemoMenu {

    private Long id;

    private String name;

    private String code;

    private Integer age;

    private Set<DemoMenu> children;
}

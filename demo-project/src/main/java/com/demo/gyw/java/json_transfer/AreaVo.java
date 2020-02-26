package com.demo.gyw.java.json_transfer;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author GouYaoWen
 * @Description
 * @Date Create in 15:31 2020/2/25
 */
@Getter
@Setter
public class AreaVo {
    /**
     * id
     */
    private String id;
    /**
     * 显示的文本
     */
    private String text;
    /**
     * 节点状态  展开与否
     */
    private String state;
    private String code;
    private String latitude;
    private int level;
    private String longitude;
    private String name;
    private String shortName;
    private int sort;
    private String parent_code;
    private String alias01;
    private String alias02;
    private String alias03;
    private String alias04;
    private String alias05;
    private List<AreaVo> children = Lists.newArrayList();
}

package com.demo.gyw.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
* @Description:    终端
* @Author:         gyw
* @CreateDate:     2019/6/13 14:51
* @Version:        1.0
*/
@Getter
@Setter
public class Terminal{
    private Long id;
    /**
     * 终端名
     */
    private String name;
    /**
     * 所在组名
     */
    private String 	groupName;
    /**
     * 所在组路径
     */
    private String groupPath;
    /**
     * 设备MAC地址
     */
    private String mac;
    /**
     * 设备IP
     */
    private String ip;
    /**
     * 最后上线时间
     */
    private LocalDateTime lastLoginTime;
    /**
     * 系统版本
     */
    private String systemVersion;
    /**
     * 应用版本
     */
    private String applicationVersion;
    /**
     * 总磁盘大小
     */
    private String totalDisk;
    /**
     * 品牌
     */
    private String brandName;
    /**
     * 序列号
     */
    private String 	serialNumber;
    /**
     * 当前节目名
     */
    private String currentProgramName;
    /**
     * 当前节目id
     */
    private Long currentProgramId;
    /**
     * 当前素材名
     */
    private String currentMaterialName;
    /**
     * 当前素材id
     */
    private Long currentMaterialId;
    /**
     * 使用磁盘空间
     */
    private String 	usedDisk;
    /**
     * 音量
     */
    private Integer volume;
    /**
     * 子网掩码
     */
    private String 	netmask;
    /**
     * 网关
     */
    private String 	gateway;
    /**
     * 默认素材id
     */
    private Long defaultMaterialId;

    /**
     * 默认素材名
     */
    private String defaultMaterialName;

    /**
     * 下线时间
     */
    private LocalDateTime offlineTime;
}

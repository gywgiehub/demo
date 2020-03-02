package com.demo.gyw.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @Description:    默认分组map
* @Author:         gyw
* @CreateDate:     2019/6/25 14:54
* @Version:        1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
public class DefaultGroupRo {
    @ApiModelProperty("分组ID")
    private Long id;

    @ApiModelProperty("分组父ID")
    private Long parentId;

    @ApiModelProperty("分组级联路径")
    private String path;

    @ApiModelProperty("分组名称")
    private String name;

    @ApiModelProperty("分组编码")
    private String code;
}

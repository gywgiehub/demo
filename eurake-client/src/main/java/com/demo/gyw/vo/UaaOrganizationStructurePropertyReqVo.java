package com.demo.gyw.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
* @Description:    java类作用描述
* @Author:         gyw
* @CreateDate:     2019/7/8 14:05
* @Version:        1.0
*/
@ApiModel(description = "uaa组织架构解析属性ReqVo")
@Data
public class UaaOrganizationStructurePropertyReqVo {
    @ApiModelProperty("菜单ID")
    private Long id;

    @ApiModelProperty("是否是全选")
    private Boolean isAllSelect;
}
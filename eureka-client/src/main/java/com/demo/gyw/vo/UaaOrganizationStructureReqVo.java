package com.demo.gyw.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description: uaa组织架构解析类ReqVo
 * @Author: gyw
 * @CreateDate: 2019/7/8 10:09
 * @Version: 1.0
 */
@ApiModel(description = "uaa组织架构解析类ReqVo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UaaOrganizationStructureReqVo {

    @ApiModelProperty("选择节目")
    //private List<UaaOrganizationStructurePropertyReqVo> programs;
    private String programs;

    @ApiModelProperty("选择终端")
    //private List<UaaOrganizationStructurePropertyReqVo> terminals;
    private String terminals;
}



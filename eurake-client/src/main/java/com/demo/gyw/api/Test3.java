package com.demo.gyw.api;

import com.demo.gyw.vo.UaaOrganizationStructurePropertyReqVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        String authority = "{\"terminals\":[{\"id\":\"123\",\"isAllSelect\":true}],\"programs\":[{\"id\":\"644029045943611392\",\"isAllSelect\":true}]}";

        String oleStr = "\"testldld\"";

        String newStr = oleStr.substring(1, oleStr.length()-1);

        System.out.printf(newStr);
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DemoTest{
        @ApiModelProperty("选择节目")
        private List<UaaOrganizationStructurePropertyReqVo> programs;

        @ApiModelProperty("选择终端")
        private List<UaaOrganizationStructurePropertyReqVo> terminals;
    }
}

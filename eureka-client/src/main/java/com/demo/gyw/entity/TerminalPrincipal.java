package com.demo.gyw.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;

/**
 * @author luanp
 * 终端连接信息
 */
@Data
@ApiModel
@NoArgsConstructor
public class TerminalPrincipal implements Principal,Cloneable {

    public TerminalPrincipal(String mac, String serialNumber) {
        this.mac = mac;
        this.serialNumber = serialNumber;

        this.name = TerminalPrincipal.toIdentity(mac, serialNumber);
    }

    @ApiModelProperty(value = "设备id",hidden = true)
    private Long terminalId;

    @ApiModelProperty(value = "设备名",hidden = true)
    private String terminalName;

    @ApiModelProperty(value = "终端标识（非终端名） 用于stomp中/user分发",hidden = true)
    private String name;

    @ApiModelProperty(value = "终端mac")
    private String mac;

    @ApiModelProperty(value = "终端序列号")
    private String serialNumber;

    /**
     * 生成终端标识
     * @param mac 设备mac
     * @param serialNo 设备序列号
     * @return 标识
     */
    public static String toIdentity(String mac, String serialNo) {
        String digest = mac + "/" + serialNo;

//        return MD5Utils.instance()
//                .digest(digest);
        return digest;
    }

    public static String toIdentity(TerminalPrincipal principal) {
        return toIdentity(principal.getMac(),principal.getSerialNumber());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

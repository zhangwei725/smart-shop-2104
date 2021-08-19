package com.smart.member.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("会员请求参数")
public class MemeberReqeust {
    @ApiModelProperty("登录用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
}

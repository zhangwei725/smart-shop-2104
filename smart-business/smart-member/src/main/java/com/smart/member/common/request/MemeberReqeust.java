package com.smart.member.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("会员请求参数")
public class MemeberReqeust {
    @ApiModelProperty("登录用户名")
    @NotNull(message = "用户名不能为空")
    private String username;
    @ApiModelProperty("密码")
    @NotNull
    private String password;

}

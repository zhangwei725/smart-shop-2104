package com.smart.member.controller;

import com.smart.member.request.MemeberReqeust;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @Api
 * @ApiOperation
 * @ApiParam 请求对象
 * @ApiModel("会员请求参数")
 * @ApiModelProperty("登录用户名")
 */

@RestController
@Api("会员功能模块")
public class MemberController {
    @ApiOperation("登录接口")
    @PostMapping("/login")
    public String login(@ApiParam("用户ID") String uid, MemeberReqeust memeberReqeust) {
        return "";
    }

}

package com.smart.member.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.smart.common.member.MemberDto;
import com.smart.common.vo.ResponseResult;
import com.smart.member.common.dto.OrderDto;

import com.smart.member.entity.Member;
import com.smart.member.common.request.MemeberReqeust;
import com.smart.member.service.MemberService;

import com.smart.member.common.vo.MemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 控制层
 * 注册登录
 * 获取用户信息
 * 修改用户的密码
 * 验证码
 * 登出
 * 修改会员信息
 * 注销
 *
 * @Api
 * @ApiOperation
 * @ApiParam 请求对象
 * @ApiModel("会员请求参数")
 * @ApiModelProperty("登录用户名")
 */

// 认证服务 post /auth/login
// 远程调用 认证服务--->调用会员服务- /member/name


@RestController
@Api("会员功能模块")
@RequestMapping("/member")
public class MemberController {
    @Resource
    MemberService memberService;

    @ApiOperation("获取当前的用户信息")
    @GetMapping("/name")
    public ResponseResult<MemberDto> getMemberInfo(@RequestParam String username) {
        MemberDto memberDto = memberService.findByName(username);
        return ResponseResult.success(memberDto);
    }

    @ApiOperation("获取当前的用户信息")
    @PostMapping("/info")
    public ResponseResult<MemberVo> info() {
        return ResponseResult.success(null);
    }


    @ApiOperation("获取所有的用户信息")
    @PostMapping("/users")
    public ResponseResult<Page<Member>> members(int page, int size) {
        return ResponseResult.success(memberService.getMemberList(page, size));
    }

    @ApiOperation("登录接口")
    @PostMapping("/register")
    public String register(MemeberReqeust memeberReqeust) {
        return "";
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/change")
    public String changeMemberInfo(MemeberReqeust memeberReqeust) {
        return "";
    }

    @ApiOperation("获取订单信息")
    @PostMapping("/orders")
    public ResponseResult<Page<OrderDto>> getMemberOrderInfo(Long memberId, Integer page, Integer size) {
        return memberService.getOrders(memberId, page, size);
    }
}

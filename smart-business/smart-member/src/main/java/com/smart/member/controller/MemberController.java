package com.smart.member.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.exception.ControllerException;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import com.smart.member.common.dto.OrderDto;
import com.smart.member.entity.Member;
import com.smart.member.common.request.MemeberReqeust;
import com.smart.member.service.MemberService;
import com.smart.member.common.utils.ShiroUtils;
import com.smart.member.common.vo.MemberVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.smart.common.vo.ResponseCode.ACCOUNT_LOGIN_ERROR;

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

@RestController
@Api("会员功能模块")
@RequestMapping("/member")
public class MemberController {
    @Resource
    MemberService memberService;


    @ApiOperation("登录接口")
    @PostMapping("/login")
    public ResponseResult<String> login(@Validated MemeberReqeust memeberReqeust) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(memeberReqeust.getUsername(), memeberReqeust.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            if (!subject.isAuthenticated()) {
                subject.login(usernamePasswordToken);
            }
        } catch (UnknownAccountException | IncorrectCredentialsException ice) {
            throw new ControllerException(ACCOUNT_LOGIN_ERROR);
        } catch (LockedAccountException lae) {
            throw new ControllerException(ResponseCode.USER_ACCOUNT_LOCKED);
        } catch (AuthenticationException ae) {
            throw new ControllerException(ResponseCode.SYSTEM_UNKNOW_ERROR);
        }
        // 返回登录成功的信息
        //  session  + cookie  JSSSIONID
        //  json web token
        // 获取sessionId
        return ResponseResult.success(ShiroUtils.getSessionId());
    }

    @ApiOperation("获取当前的用户信息")
    @PostMapping("/info")
    public ResponseResult<MemberVo> info() {
        MemberVo memberVo = (MemberVo) SecurityUtils.getSubject().getPrincipal();
        return ResponseResult.success(memberVo);
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

    @ApiOperation("登录接口")
    @PostMapping("/change")
    public String changeMemberInfo(MemeberReqeust memeberReqeust) {
        return "";
    }

    @ApiOperation("登出接口")
    @PostMapping("/logout")
    public ResponseResult<String> logout() {
        SecurityUtils.getSubject().logout();
        return ResponseResult.success("登出成功");
    }

    @ApiOperation("获取订单信息")
    @PostMapping("/orders")
    public ResponseResult<Page<OrderDto>> getMemberOrderInfo(Long memberId, Integer page, Integer size) {
        return memberService.getOrders(memberId, page, size);
    }
}

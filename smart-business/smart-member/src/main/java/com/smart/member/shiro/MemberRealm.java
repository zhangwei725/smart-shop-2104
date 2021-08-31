package com.smart.member.shiro;

import com.smart.member.entity.Member;
import com.smart.member.service.MemberService;
import com.smart.member.common.vo.MemberVo;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;

/**
 * 认证功能
 */
public class MemberRealm extends AuthenticatingRealm {

    @Resource
    MemberService memberService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Member member = memberService.findByName(username);
        if (member == null) {
            throw new UnknownAccountException();
        }
        if (member.getLocked()) {
            throw new LockedAccountException();
        }
        MemberVo memberVo = new MemberVo();
        BeanUtils.copyProperties(member, memberVo);
        return new SimpleAuthenticationInfo(memberVo, member.getPassword(), ByteSource.Util.bytes(member.getUsername()), username);
    }
}

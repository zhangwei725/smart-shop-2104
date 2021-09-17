package com.smart.auth.service;

import com.smart.auth.api.MemberFeignApi;
import com.smart.auth.vo.MemberVo;
import com.smart.common.member.MemberDto;
import com.smart.common.vo.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    MemberFeignApi feignApi;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseResult<MemberDto> responseResult = feignApi.getUserInfo(username);
        MemberVo memberVo = new MemberVo();
        BeanUtils.copyProperties(responseResult.getData(), memberVo);
        return memberVo;
    }
}

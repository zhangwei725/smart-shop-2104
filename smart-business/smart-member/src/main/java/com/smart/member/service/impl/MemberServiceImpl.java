package com.smart.member.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.vo.ResponseResult;
import com.smart.member.api.OrderApi;
import com.smart.member.common.dto.OrderDto;
import com.smart.member.entity.Member;
import com.smart.member.mapper.MemberMapper;
import com.smart.member.common.request.MemeberReqeust;
import com.smart.member.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;
    @Resource
    OrderApi orderApi;


    @Override
    public Member findByName(String username) {
        return memberMapper.selectByUsername(username);
    }

    @Override
    public int register(MemeberReqeust memeberReqeust) {
        return 0;
    }

    @Override
    public int changeMember(MemeberReqeust memeberReqeust) {
        return 0;
    }

    @Override
    public int getCurrentMemberInfo() {
        return 0;
    }

    @Override
    public Page<Member> getMemberList(int page, int size) {
        return memberMapper.selectPage(new Page<>(page, size), null);

    }

    @Override
    public ResponseResult<Page<OrderDto>> getOrders(Long memberId, Integer page, Integer size) {
        return orderApi.getOrders(memberId, page, size);
    }
}

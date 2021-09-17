package com.smart.member.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.member.MemberDto;
import com.smart.common.vo.ResponseResult;
import com.smart.member.common.dto.OrderDto;
import com.smart.member.entity.Member;
import com.smart.member.common.request.MemeberReqeust;

public interface MemberService {
    MemberDto findByName(String username);

    int register(MemeberReqeust memeberReqeust);

    int changeMember(MemeberReqeust memeberReqeust);

    int getCurrentMemberInfo();

    Page<Member> getMemberList(int page, int size);

    ResponseResult<Page<OrderDto>> getOrders(Long memberId, Integer page, Integer size);
}

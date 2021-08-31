package com.smart.member.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.member.entity.Member;

public interface MemberMapper extends BaseMapper<Member> {
    default Member selectByUsername(String username) {
        QueryWrapper<Member> qw = new QueryWrapper<>();
        qw.lambda().eq(Member::getUsername, username);
        return this.selectOne(qw);
    }
}
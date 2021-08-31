package com.smart.order.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.order.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {

    default Page<Order> selectOrdersByMemberId(Long memberId, Integer currentPage, Integer size) {
        Page<Order> page = new Page<>(currentPage, size);
        QueryWrapper<Order> qw = new QueryWrapper<>();
        qw.lambda().eq(Order::getMemberId, memberId).eq(Order::getStatus, 1);
        return this.selectPage(page, qw);
    }
}
package com.smart.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.order.controller.OrderController;
import com.smart.order.dto.OrderDto;
import com.smart.order.reqeust.OrderReqeustParams;
import com.smart.order.vo.OrderVo;

/**
 *
 */
public interface OrderService {

    OrderVo createOrder(OrderReqeustParams orderReqeustParams);

    Page<OrderDto> getOrdersByMemberId(Long memberId, Integer page, Integer size);
}

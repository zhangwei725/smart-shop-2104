package com.smart.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.vo.ResponseResult;
import com.smart.order.dto.OrderDto;
import com.smart.order.reqeust.OrderReqeustParams;
import com.smart.order.service.OrderService;
import com.smart.order.vo.OrderVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 1. 确认订单
 * 2. 创建订单
 * 3. 取消订单
 * 4. 获取订单信息
 * 5  申请退货
 * 6  确认收货
 * 7  修改订单
 * 8  获取订单的详细信息
 * 确认订单
 * uid  --- 收货地址信息
 * cartId  [1,2]选中的购物车ID    会员ID 商品ID 店铺ID 购物买数量
 * productId  显示优惠信息
 * 100 减 50
 * 9.5 折
 * 提交订单
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    @PostMapping("/create")
    public ResponseResult<OrderVo> createOrder(@RequestBody OrderReqeustParams orderReqeustParams) {
        OrderVo order = orderService.createOrder(orderReqeustParams);
        return ResponseResult.success(order);
    }

    @GetMapping("/list")
    public ResponseResult<Page<OrderDto>> getOrders(Long memberId, Integer page, Integer size) {
        return ResponseResult.success(orderService.getOrdersByMemberId(memberId, page, size));
    }

}

package com.smart.member.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.vo.ResponseResult;
import com.smart.member.api.callback.OrderApiCallback;
import com.smart.member.common.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = FeignConstants.CONSTANTS_ORDER_SERVER,
        path = FeignConstants.CONSTANTS_ORDER_PREFIX_PATH,
        fallback = OrderApiCallback.class)
public interface OrderApi {
    @GetMapping("/list")
    ResponseResult<Page<OrderDto>> getOrders(@RequestParam Long memberId, @RequestParam Integer page, @RequestParam Integer size);
}

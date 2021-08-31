package com.smart.member.api.callback;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.common.vo.ResponseResult;
import com.smart.member.api.OrderApi;
import com.smart.member.common.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 降级表示 返回默认的约定的数据  一般是空数据
 * 数据同步的问题
 */
@Component
public class OrderApiCallback implements OrderApi {
    @Override
    public ResponseResult<Page<OrderDto>> getOrders(Long memberId, Integer page, Integer size) {
        Page<OrderDto> orderDtoPage = new Page<>();
        orderDtoPage.setRecords(new ArrayList<>());
        return ResponseResult.success(orderDtoPage);
    }
}

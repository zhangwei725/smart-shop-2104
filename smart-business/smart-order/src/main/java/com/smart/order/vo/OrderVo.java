package com.smart.order.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * xxx-订单
 */
@Data
@Builder
public class OrderVo {
    private String orderNo;
    private BigDecimal total;
    private String subject;

}

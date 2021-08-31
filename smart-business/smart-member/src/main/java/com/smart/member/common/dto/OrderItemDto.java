package com.smart.member.common.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderItemDto {
    private Long orderItemId;

    private String orderNo;

    private String imgUrl;

    private Integer quantity;

    private String title;

    private BigDecimal originalPrice;

    private BigDecimal discountPrice;

    private Long productId;

    private Date createDate;
    private Integer status;
}

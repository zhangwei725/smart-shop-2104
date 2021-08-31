package com.smart.order.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDto {
    private Long orderId;
    private String orderNo;

    private Long memberId;

    private String username;

    private String phone;

    private String detail;

    private Byte payType;

    private Date createDate;

    private Integer status;
    private BigDecimal total;
    private OrderItemDto orderItemDto;


}

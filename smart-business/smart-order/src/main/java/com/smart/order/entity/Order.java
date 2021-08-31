package com.smart.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "oms_order")
public class Order {
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private Long orderId;

    @TableField(value = "order_no")
    private String orderNo;

    @TableField(value = "member_id")
    private Long memberId;

    @TableField(value = "username")
    private String username;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "detail")
    private String detail;

    @TableField(value = "pay_type")
    private Byte payType;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "`status`")
    private Integer status;

    @TableField(value = "total")
    private BigDecimal total;

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_ORDER_NO = "order_no";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_USERNAME = "username";

    public static final String COL_PHONE = "phone";

    public static final String COL_DETAIL = "detail";

    public static final String COL_PAY_TYPE = "pay_type";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_STATUS = "status";

    public static final String COL_TOTAL = "total";
}
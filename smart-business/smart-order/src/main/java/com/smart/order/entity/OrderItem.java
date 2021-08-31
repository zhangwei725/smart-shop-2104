package com.smart.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
@TableName(value = "oms_order_item")
public class OrderItem {
    public static final String COL_ORDER_ID = "order_id";
    @TableId(value = "order_item_id", type = IdType.ASSIGN_ID)
    private Long orderItemId;

    @TableField(value = "order_no")
    private String orderNo;

    @TableField(value = "image_url")
    private String imgUrl;

    @TableField(value = "quantity")
    private Integer quantity;

    @TableField(value = "title")
    private String title;

    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    @TableField(value = "discount_price")
    private BigDecimal discountPrice;

    @TableField(value = "product_id")
    private Long productId;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "`status`")
    private Integer status;

    public static final String COL_ORDER_ITEM_ID = "order_item_id";

    public static final String COL_ORDER_NO = "order_no";

    public static final String COL_IMAGE_URL = "image_url";

    public static final String COL_QUANTITY = "quantity";

    public static final String COL_TITLE = "title";

    public static final String COL_ORIGINAL_PRICE = "original_price";

    public static final String COL_DISCOUNT_PRICE = "discount_price";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_STATUS = "status";
}
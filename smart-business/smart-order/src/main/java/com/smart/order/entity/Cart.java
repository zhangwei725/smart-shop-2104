package com.smart.order.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;

import lombok.Data;

@Data
@TableName(value = "oms_cart")
public class Cart {
    @TableId(value = "cart_id", type = IdType.ASSIGN_ID)
    private Long cartId;

    /**
     * 会员ID
     */
    @TableField(value = "member_id")
    private Long memberId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 商品标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 商品的价格
     */
    @TableField(value = "discount_price")
    private BigDecimal discountPrice;

    /**
     * 商品的数量
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 商品的图片
     */
    @TableField(value = "img_url")
    private String imgUrl;

    /**
     * 状态
     */
    @TableField(value = "`status`")
    @TableLogic(value = "1", delval = "0")
    private Integer status;

    @TableField(value = "original_price")
    private BigDecimal originalPrice;

    public static final String COL_CART_ID = "cart_id";

    public static final String COL_MEMBER_ID = "member_id";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_TITLE = "title";

    public static final String COL_DISCOUNT_PRICE = "discount_price";

    public static final String COL_QUANTITY = "quantity";

    public static final String COL_IMG_URL = "img_url";

    public static final String COL_STATUS = "status";

    public static final String COL_ORIGINAL_PRICE = "original_price";
}
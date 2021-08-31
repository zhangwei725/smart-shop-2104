package com.smart.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName(value = "ims_stock")
public class Stock {
    @TableId(value = "stock_id", type = IdType.INPUT)
    private Long stockId;

    /**
     * 商品ID
     */
    @TableField(value = "product_id")
    private Long productId;

    /**
     * 商品的总量
     */
    @TableField(value = "total")
    private Integer total;

    /**
     * 版本号 乐观锁
     */
    @TableField(value = "version")
    private Integer version;

    public static final String COL_STOCK_ID = "stock_id";

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_TOTAL = "total";

    public static final String COL_VERSION = "version";
}
package com.smart.order.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangwei
 */
@Data
@ApiModel("商品参数")
public class ProductRequestParams {
    @ApiModelProperty("购物车ID")
    private Long cartId;
    @ApiModelProperty("购买的商品数量")
    private Integer quantity;
    @ApiModelProperty("商品ID")
    private Long productId;
}

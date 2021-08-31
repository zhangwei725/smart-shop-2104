package com.smart.order.reqeust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 基本信息
 * 商品信息
 * 促销信息
 * 支付信息
 * 物流信息
 * 发票信息
 * 仓储信息
 */
@Data
@ApiModel("订单请求参数")
public class OrderReqeustParams {
    @ApiModelProperty("会员ID")
    private Long memberId;
    @ApiModelProperty("购物车商品信息")
    private List<ProductRequestParams> productParamsList;
    @ApiModelProperty("商家留言")
    private String msg;
    @ApiModelProperty("收货地址")
    private String receiverAddress;
    @ApiModelProperty("收货人")
    private String receiverName;
    @ApiModelProperty("收货手机号")
    private String receiverPhone;
    /**
     * 10 pc 11 安卓  12 ios  20 小程序  31 其他
     */
    private Integer platformType;
}

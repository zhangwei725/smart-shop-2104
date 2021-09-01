package com.smart.ali.service;

import com.smart.pay.reqeust.AliPayRequestParam;

public interface AliPayService {


    /* ===== 支付相关接口   */
    String webPay(AliPayRequestParam payRequestParam) throws Exception;

    String appPay(AliPayRequestParam payRequestParam) throws Exception;
    /* =====退款接口 ===== */


}

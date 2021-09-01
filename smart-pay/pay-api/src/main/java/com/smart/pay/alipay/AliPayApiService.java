package com.smart.pay.alipay;

import com.smart.pay.reqeust.AliPayRequestParam;

/**
 * app支付
 * h5支付
 * 前后端不分离支付  小程序支付
 */
public interface AliPayApiService {
    /**
     * web 支付
     * app 支付
     *
     * @param client 1 表示 app  2 表示web
     * @return
     */
    String pay(int client, AliPayRequestParam payRequestParam) throws Exception;
}

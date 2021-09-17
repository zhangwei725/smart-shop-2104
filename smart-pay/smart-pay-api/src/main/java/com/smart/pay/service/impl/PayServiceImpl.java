package com.smart.pay.service.impl;

import com.smart.pay.alipay.AliPayApiService;
import com.smart.pay.reqeust.AliPayRequestParam;
import com.smart.pay.service.PayService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {
    @DubboReference
    AliPayApiService aliPayApiService;

    @Override
    public String pay(int type, int client, AliPayRequestParam payRequestParam) throws Exception {
        String payInfo = null;
        if (type == 1) {
            payInfo = aliPayApiService.pay(client, payRequestParam);
        } else if (type == 2) {

        }
        return payInfo;
    }
}

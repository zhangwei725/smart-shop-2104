package com.smart.ali.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.smart.ali.service.AliPayService;
import com.smart.pay.alipay.AliPayApiService;
import com.smart.pay.reqeust.AliPayRequestParam;
import org.springframework.stereotype.Service;

@Service
public class AlipayServiceImpl implements AliPayService {
    //    @Override
//    public String pay(int client, AliPayRequestParam payRequestParam) throws Exception {
//        String payLink = null;
//        if (client == 1) {
//            payLink = appPay(payRequestParam);
//        }
//        return payLink;
//    }
//    pc端支付
    @Override
    public String webPay(AliPayRequestParam payRequestParam) throws Exception {
        AlipayTradePagePayResponse response = Factory.Payment.Page().pay(payRequestParam.getSubject(),
                payRequestParam.getOutRradeNo(), payRequestParam.getTotalAmount(), "https://www.baidu.com");
        return response.getBody();
    }

    /**
     * 生成支付连接
     *
     * @param payRequestParam
     * @return
     */
    @Override
    public String appPay(AliPayRequestParam payRequestParam) throws Exception {
        String body = null;
        AlipayTradeAppPayResponse response = Factory.Payment.App().pay(payRequestParam.getSubject(),
                payRequestParam.getOutRradeNo(), payRequestParam.getTotalAmount());
        //电脑网站支付
//        Factory.Payment.Page();
        //生成支付连接成功
        if (ResponseChecker.success(response)) {
            body = response.getBody();
        }
        return body;
    }
}

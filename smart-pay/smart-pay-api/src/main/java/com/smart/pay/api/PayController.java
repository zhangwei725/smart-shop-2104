package com.smart.pay.api;

import com.alibaba.nacos.api.naming.pojo.healthcheck.impl.Http;
import com.smart.common.vo.ResponseResult;
import com.smart.pay.reqeust.AliPayRequestParam;
import com.smart.pay.service.PayService;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    PayService payService;

    /**
     * 1 表示 支付宝支付
     * 2 表示微信支付
     * 3 表示银联支付
     *
     * @return
     */
    @PostMapping("/")
    public ResponseResult<String> pay(int type, int client, AliPayRequestParam payRequestParam) {
        String pay = null;
        try {
            pay = payService.pay(type, client, payRequestParam);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.success(pay);
    }
}

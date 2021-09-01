package com.smart.ali.controller;

import com.smart.ali.service.AliPayService;
import com.smart.common.vo.ResponseResult;
import com.smart.pay.reqeust.AliPayRequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestControler {
    @Resource
    AliPayService aliPayService;

    @PostMapping("pay")
    public ResponseResult<String> pay() throws Exception {
        AliPayRequestParam aliPayRequestParam = new AliPayRequestParam();
        aliPayRequestParam.setTotalAmount("0.01");
        aliPayRequestParam.setOutRradeNo("123");
        aliPayRequestParam.setSubject("智慧商城-支付订单");
        return ResponseResult.success(aliPayService.appPay(aliPayRequestParam));
    }


    @PostMapping("page")
    public ResponseResult<String> page() throws Exception {
        AliPayRequestParam aliPayRequestParam = new AliPayRequestParam();
        aliPayRequestParam.setTotalAmount("0.01");
        aliPayRequestParam.setOutRradeNo("123");
        aliPayRequestParam.setSubject("智慧商城-支付订单");
        return ResponseResult.success(aliPayService.webPay(aliPayRequestParam));
    }
}

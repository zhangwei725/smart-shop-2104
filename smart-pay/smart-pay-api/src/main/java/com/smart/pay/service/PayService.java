package com.smart.pay.service;

import com.smart.pay.reqeust.AliPayRequestParam;
import com.smart.pay.reqeust.OrderInfo;

public interface PayService {
    String pay(int type, int client, AliPayRequestParam payRequestParam) throws Exception;
}

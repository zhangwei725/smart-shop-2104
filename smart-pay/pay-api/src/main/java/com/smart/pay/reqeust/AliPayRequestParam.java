package com.smart.pay.reqeust;

import lombok.Data;

/**
 *
 */
@Data
public class AliPayRequestParam {
    private String outRradeNo;
    private String subject;
    private String totalAmount;

}

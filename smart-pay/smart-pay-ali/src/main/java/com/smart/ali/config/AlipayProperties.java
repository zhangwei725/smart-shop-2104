package com.smart.ali.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("pay.ali")
@Data
public class AlipayProperties {
    /**
     * 协议
     */
    private String protocol = "https";
    /**
     * 支付网关
     */
    private String gatewayHost = "openapi.alipay.com";
    /**
     * 加密方式
     */
    private String signType = "RSA2";
    /**
     * 应用程序ID
     */
    private String appId;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;
    /**
     * 编码
     */
    private String charset;

}

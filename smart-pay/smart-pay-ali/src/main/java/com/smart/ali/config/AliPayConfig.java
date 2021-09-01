package com.smart.ali.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class AliPayConfig {
    @Resource
    AlipayProperties alipayProperties;
    @Resource
    private Config config;


    @PostConstruct
    public void init() {
        Factory.setOptions(config);
    }


    @Bean
    public Config config() {
        Config config = new Config();
        config.protocol = alipayProperties.getProtocol();
        config.appId = alipayProperties.getAppId();
        config.alipayPublicKey = alipayProperties.getAlipayPublicKey();
        config.gatewayHost = alipayProperties.getGatewayHost();
        config.merchantPrivateKey = alipayProperties.getPrivateKey();
        config.signType = alipayProperties.getSignType();
        return config;
    }


}

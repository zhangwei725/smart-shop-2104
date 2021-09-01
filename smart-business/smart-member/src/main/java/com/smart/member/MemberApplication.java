package com.smart.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * When I write this only God and  I know
 * Now  God only knows Do not touch
 *
 * @author zhangwei
 *
 */
@SpringBootApplication(scanBasePackages = "com.smart")
// 注册所有的FeignClient 接口
@EnableFeignClients
@EnableDiscoveryClient
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}

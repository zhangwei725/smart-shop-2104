package com.smart.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * When I write this only God and  I know
 * Now  God only knows
 * Do not touch
 * @author zhangwei
 */
@SpringBootApplication(scanBasePackages = "com.smart")
public class MemberApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
}

package com.smart.ali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication(scanBasePackages = "com.smart")
public class AliPayApp {
    public static void main(String[] args) {
        SpringApplication.run(AliPayApp.class, args);
    }
}

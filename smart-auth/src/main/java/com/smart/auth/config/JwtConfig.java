package com.smart.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("white")
@Data
public class JwtConfig {
    private String[] antMatchers;
}

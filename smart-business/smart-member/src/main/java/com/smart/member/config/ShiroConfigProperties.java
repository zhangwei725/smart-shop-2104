package com.smart.member.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangwei
 */
@Configuration
@Data
@ConfigurationProperties("shiro")
public class ShiroConfigProperties {
    private String[] pathList;
    private String logoutPath;
}

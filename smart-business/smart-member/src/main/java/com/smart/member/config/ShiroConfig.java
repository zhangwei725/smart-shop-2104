package com.smart.member.config;

import com.smart.member.shiro.MemberRealm;
import com.smart.member.shiro.MyWebSessionManager;
import com.smart.member.common.utils.ShiroUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * @author zhangwei
 */
@Configuration
public class ShiroConfig {
    @Resource
    ShiroConfigProperties shiroConfigProperties;

    @Bean
    public MemberRealm realm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        MemberRealm memberRealm = new MemberRealm();
        memberRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return memberRealm;
    }

    /**
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(MemberRealm realm, DefaultWebSessionManager webSessionManager) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        defaultWebSecurityManager.setSessionManager(webSessionManager);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition shiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        String[] pathList = shiroConfigProperties.getPathList();
        for (String path : pathList) {
            shiroFilterChainDefinition.addPathDefinition(path, ShiroUtils.SHIRO_ANON);
        }
        shiroFilterChainDefinition.addPathDefinition(shiroConfigProperties.getLogoutPath(), ShiroUtils.SHIRO_LOGOUT);
        shiroFilterChainDefinition.addPathDefinition("/**", ShiroUtils.SHIRO_AUTHC);
        return shiroFilterChainDefinition;
    }

    /**
     * 散列算法
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashedCredentialsMatcher.setHashIterations(ShiroUtils.SHIRO_HASH_ITERATIONS);
        return hashedCredentialsMatcher;
    }

    /**
     * Session
     * redis
     */

    /**
     * 前后端分离
     *
     * @return
     */
    @Bean
    @Primary
    public MyWebSessionManager sessionManager() {
        MyWebSessionManager defaultWebSessionManager = new MyWebSessionManager();
        defaultWebSessionManager.setSessionIdCookieEnabled(true);
        // 设置session的过期时间
        defaultWebSessionManager.setGlobalSessionTimeout(30 * 24 * 60 * 60);
        return defaultWebSessionManager;
    }
}

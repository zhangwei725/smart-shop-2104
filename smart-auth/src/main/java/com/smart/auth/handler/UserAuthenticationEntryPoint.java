package com.smart.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.auth.utils.ResponseUtils;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.naming.spi.ResolveResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未登录处理类
 *
 * @author zhangwei
 */
@Component
public class UserAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Resource
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseUtils.responseToJson(httpServletResponse, objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.ACCOUNT_NOT_LOGIN)));
    }
}
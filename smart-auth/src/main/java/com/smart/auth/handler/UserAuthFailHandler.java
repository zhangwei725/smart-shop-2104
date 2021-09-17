package com.smart.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.auth.utils.ResponseUtils;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理
 */
@Component
public class UserAuthFailHandler implements AuthenticationFailureHandler {
    @Resource
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        ResponseResult<Object> result;
        if (exception instanceof UsernameNotFoundException | exception instanceof BadCredentialsException) {
            result = ResponseResult.error(ResponseCode.ACCOUNT_LOGIN_ERROR);
        } else if (exception instanceof LockedException) {
            result = ResponseResult.error(ResponseCode.USER_ACCOUNT_LOCKED);
        } else {
            //认证失败
            result = ResponseResult.error(ResponseCode.AUTH_ERROR);
        }
        ResponseUtils.responseToJson(response, objectMapper.writeValueAsString(result));
    }

}

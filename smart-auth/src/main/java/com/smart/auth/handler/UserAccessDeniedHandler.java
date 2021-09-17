package com.smart.auth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.auth.utils.ResponseUtils;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.naming.spi.ResolveResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class UserAccessDeniedHandler implements AccessDeniedHandler {
    @Resource
    ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseUtils.responseToJson(httpServletResponse, objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.PERMISSION_NO_ACCESS)));
    }
}

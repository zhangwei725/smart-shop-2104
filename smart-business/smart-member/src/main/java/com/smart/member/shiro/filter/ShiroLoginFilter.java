package com.smart.member.shiro.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 没有授权
 */
@Component
@Primary
public class ShiroLoginFilter extends FormAuthenticationFilter {
    @Resource
    ObjectMapper mapper;

    /**
     * 当shiro校验用户未登录时，返回JSON数据代替原有的跳转到登录界面
     *
     * @param servletRequest
     * @param servletResponse
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write(new ObjectMapper().writeValueAsString(ResponseResult.error(ResponseCode.ACCOUNT_NOT_LOGIN)));
        out.flush();
        out.close();
        return false;
    }

}

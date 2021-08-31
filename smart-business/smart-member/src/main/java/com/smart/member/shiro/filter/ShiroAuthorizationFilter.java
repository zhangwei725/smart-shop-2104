package com.smart.member.shiro.filter;

import cn.hutool.json.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.common.vo.ResponseCode;
import com.smart.common.vo.ResponseResult;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 没有权限
 */
@Component
@Primary
public class ShiroAuthorizationFilter extends RolesAuthorizationFilter {
    @Resource
    ObjectMapper objectMapper;

    /**
     * 校验用户权限，当无权限时返回JSON数据代替原有的跳转到界面
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        Subject subject = getSubject(servletRequest, servletResponse);
        // 没有认证,先返回未认证的json
        String json = subject.getPrincipal() == null ?
                objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.ACCOUNT_NOT_LOGIN))
                : objectMapper.writeValueAsString(ResponseResult.error(ResponseCode.UN_AUTH));
        out.write(json);
        out.flush();
        out.close();
        return false;
    }

}
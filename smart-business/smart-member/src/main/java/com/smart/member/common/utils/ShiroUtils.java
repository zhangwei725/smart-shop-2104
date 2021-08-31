package com.smart.member.common.utils;

import com.smart.member.common.vo.MemberVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
    public static final int SHIRO_HASH_ITERATIONS = 100;
    public static final String SHIRO_ANON = "anon";
    public static final String SHIRO_AUTHC = "authc";
    public static final String SHIRO_LOGOUT = "logout";

    public static String sha256(String password, String salt) {
        SimpleHash simpleHash = new SimpleHash(Sha256Hash.ALGORITHM_NAME, password, salt, SHIRO_HASH_ITERATIONS);
        return simpleHash.toString();
    }

    public static String getSessionId() {
        return SecurityUtils.getSubject().getSession().getId().toString();
    }

    /**
     * 获取会话
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * Subject：主体，代表了当前“用户”
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static MemberVo getMember() {
        return (MemberVo) SecurityUtils.getSubject().getPrincipal();
    }

    public static Long getMemberId() {
        return getMember().getMemberId();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    /**
     *
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }
}

package com.smart.common.member;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理端
 */
@Data
public class MemberDto implements Serializable {
    /**
     * 用户Id
     */
    private Long memberId;

    /**
     * 用户名
     */

    private String username;
    /**
     * 密码
     */
    private String password;

}

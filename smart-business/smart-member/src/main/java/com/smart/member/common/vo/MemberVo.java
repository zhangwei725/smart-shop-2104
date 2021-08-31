package com.smart.member.common.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberVo {
    /**
     * 用户Id
     */
    private Long memberId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机
     */
    private String phone;

    /**
     * 性别 1 表示男 0 表示女 2 表示 保密
     */
    private Boolean sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String mark;

    /**
     * 头像图片路径
     */
    private String head;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date regTime;

    /**
     * 账号是否被锁定 1 表示未锁定 0 表示锁定
     */
    private Boolean locked;
}

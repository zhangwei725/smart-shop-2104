package com.smart.web.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class BannerVo {
    private Long navId;
    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 轮播图地址
     */
    private String imgUrl;

    /**
     * 详情地址
     */
    private String url;

    /**
     * 1表示pc，0表示移动端
     */
    private Integer type;

    /**
     * 排序字段
     */
    private Integer order;

    /**
     * 创建时间
     */
    private Date creatDate;

}

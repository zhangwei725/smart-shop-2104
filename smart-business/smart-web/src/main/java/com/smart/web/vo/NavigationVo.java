package com.smart.web.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;


@Data
public class NavigationVo {
    /**
     * 
     */
    @TableId(value = "nav_id", type = IdType.AUTO)
    private Integer navId;

    @TableField(value = "`name`")
    private String name;
    /**
     * 跳转的地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 排序字段
     */
    private Integer order;
    /**
     * 是否显示
     */
    @TableField(value = "is_show")
    private Integer isShow;


    @TableField(value = "`type`")
    private Integer type;

}

package com.smart.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
    * 标题
    */
@Data
@TableName(value = "banner")
public class Banner {
    @TableId(value = "nav_id", type = IdType.ASSIGN_ID)
    private Long navId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 轮播图地址
     */
    @TableField(value = "img_url")
    private String imgUrl;

    /**
     * 详情地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 1正常 0异常
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 1表示pc，0表示移动端
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 排序字段
     */
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 创建时间
     */
    @TableField(value = "creat_date")
    private Date creatDate;

    /**
     * 修改时间
     */
    @TableField(value = "update_date")
    private Date updateDate;

    public static final String COL_NAV_ID = "nav_id";

    public static final String COL_TITLE = "title";

    public static final String COL_IMG_URL = "img_url";

    public static final String COL_URL = "url";

    public static final String COL_STATUS = "status";

    public static final String COL_TYPE = "type";

    public static final String COL_ORDER = "order";

    public static final String COL_CREAT_DATE = "creat_date";

    public static final String COL_UPDATE_DATE = "update_date";
}
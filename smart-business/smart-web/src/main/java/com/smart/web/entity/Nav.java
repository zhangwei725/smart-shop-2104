package com.smart.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
    * 导航信息表
    */
@Data
@TableName(value = "nav")
public class Nav {
    @TableId(value = "nav_id", type = IdType.ASSIGN_ID)
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
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 是否显示
     */
    @TableField(value = "is_show")
    private Integer isShow;

    /**
     * 1表示PC，2表示移动端
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 1表示正常,0表示删除
     */
    @TableField(value = "`status`")
    private Integer status;

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

    public static final String COL_NAME = "name";

    public static final String COL_URL = "url";

    public static final String COL_ORDER = "order";

    public static final String COL_IS_SHOW = "is_show";

    public static final String COL_TYPE = "type";

    public static final String COL_STATUS = "status";

    public static final String COL_CREAT_DATE = "creat_date";

    public static final String COL_UPDATE_DATE = "update_date";
}
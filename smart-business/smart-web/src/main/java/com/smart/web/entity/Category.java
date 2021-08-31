package com.smart.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.Data;

/**
 * 菜单
 */
@Data
@TableName(value = "category")
public class Category {
    @TableId(value = "cate_id", type = IdType.AUTO)
    private Integer cateId;

    @TableField(value = "`name`")
    private String name;

    /**
     * 1表示一级菜单，2表示二级菜单
     */
    @TableField(value = "`level`")
    private Integer level;

    /**
     * 排序字段
     */
    @TableField(value = "`order`")
    private Integer order;

    /**
     * 1正常 0异常
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 0表示1级，没有父类
     */
    @TableField(value = "parent_id")
    private Integer parentId;

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

    public static final String COL_CATE_ID = "cate_id";

    public static final String COL_NAME = "name";

    public static final String COL_LEVEL = "level";

    public static final String COL_ORDER = "order";

    public static final String COL_STATUS = "status";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_CREAT_DATE = "creat_date";

    public static final String COL_UPDATE_DATE = "update_date";
}
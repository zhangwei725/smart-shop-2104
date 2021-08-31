package com.smart.web.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    private Integer cateId;
    private String name;
    /**
     * 1表示一级菜单，2表示二级菜单
     */
    private Integer level;

    /**
     * 排序字段
     */
    private Integer order;

    /**
     * 1正常 0异常
     */
    private Integer status;

    /**
     * 0表示1级，没有父类
     */
    private Integer parentId;


    //二级菜单
    private List<CategoryVo> subCategoryList;
    /**
     * 三级菜单
     */
    private List<CategoryVo> thirdCategoryList;
}

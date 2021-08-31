package com.smart.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.web.entity.Category;
import com.smart.web.vo.CategoryVo;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVo> selectList();

}
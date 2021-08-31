package com.smart.web.service.impl;

import com.smart.web.mapper.CategoryMapper;
import com.smart.web.service.CategoryService;
import com.smart.web.vo.CategoryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryVo> list() {
        return categoryMapper.selectList();
    }
}

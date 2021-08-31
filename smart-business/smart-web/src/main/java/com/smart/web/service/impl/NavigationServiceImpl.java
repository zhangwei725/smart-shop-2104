package com.smart.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.common.utils.ConvertBeanUtils;
import com.smart.web.entity.Nav;
import com.smart.web.mapper.NavMapper;
import com.smart.web.service.NavigationService;
import com.smart.web.vo.NavigationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {
    @Resource
    NavMapper navMapper;

    @Override
    public List<NavigationVo> list() {
        QueryWrapper<Nav> qw = new QueryWrapper<>();
        qw.lambda().eq(Nav::getIsShow, 1).eq(Nav::getStatus, 1);
        return ConvertBeanUtils.convertListTo(navMapper.selectList(qw), NavigationVo::new);
    }
}

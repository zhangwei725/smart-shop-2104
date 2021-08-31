package com.smart.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.common.utils.ConvertBeanUtils;
import com.smart.web.entity.Banner;
import com.smart.web.mapper.BannerMapper;
import com.smart.web.service.BannerService;
import com.smart.web.vo.BannerVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    BannerMapper bannerMapper;
    @Override
    public List<BannerVo> list() {
        QueryWrapper<Banner> qw = new QueryWrapper<>();
        qw.lambda().eq(Banner::getStatus, 1);
        List<Banner> banners = bannerMapper.selectList(qw);
        return ConvertBeanUtils.convertListTo(banners, BannerVo::new);
    }
}

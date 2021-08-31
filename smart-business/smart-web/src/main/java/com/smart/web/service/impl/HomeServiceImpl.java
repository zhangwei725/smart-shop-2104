package com.smart.web.service.impl;

import com.smart.web.service.BannerService;
import com.smart.web.service.CategoryService;
import com.smart.web.service.HomeService;
import com.smart.web.service.NavigationService;
import com.smart.web.vo.HomeTopResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    BannerService bannerService;

    @Resource
    CategoryService categoryService;

    @Resource
    NavigationService navigationService;
        
    @Override
    public HomeTopResult getTopData() {
        HomeTopResult result = new HomeTopResult();
        //获取轮保数据
        result.setBanners(bannerService.list());
        result.setNavigations(navigationService.list());
        result.setCategories(categoryService.list());
        return result;
    }
}

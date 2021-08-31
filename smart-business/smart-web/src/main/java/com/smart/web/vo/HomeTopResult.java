package com.smart.web.vo;

import lombok.Data;

import java.util.List;

@Data
public class HomeTopResult {
    private List<BannerVo> banners;
    private List<NavigationVo> navigations;
    private List<CategoryVo> categories;
}

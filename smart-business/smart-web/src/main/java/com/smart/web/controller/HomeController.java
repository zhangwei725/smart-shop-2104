package com.smart.web.controller;

import com.smart.common.vo.ResponseResult;
import com.smart.web.service.HomeService;
import com.smart.web.vo.HomeTopResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomeController {
    @Resource
    HomeService homeService;

    @GetMapping("/head")
    public ResponseResult<HomeTopResult> top() {
        return ResponseResult.success(homeService.getTopData());
    }
}

package com.smart.auth.api;

import com.smart.common.member.MemberDto;
import com.smart.common.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "smart-member", path = "/member")
public interface MemberFeignApi {
    @GetMapping("/name")
    ResponseResult<MemberDto> getUserInfo(@RequestParam String username);
}

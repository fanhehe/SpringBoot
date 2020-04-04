package com.fanhehe.home.system.user.service;

import com.fanhehe.home.system.IService;
import com.fanhehe.home.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user", configuration = FeignConfig.class, fallback = UserServiceFallback.class)
public interface UserService extends IService {
    @GetMapping("/user/create")
    String createUser(@RequestParam("phoneRegion") String phoneRegion, @RequestParam("phoneNumber") String phoneNumber);
}

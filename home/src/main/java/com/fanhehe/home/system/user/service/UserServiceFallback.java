package com.fanhehe.home.system.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service("UserSystemFallback")
public class UserServiceFallback implements UserService {
    public String createUser(@RequestParam("phoneRegion") String phoneRegion, @RequestParam("phoneNumber") String phoneNumber) {
        return "create-user-fallback";
    }
}

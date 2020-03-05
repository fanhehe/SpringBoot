package com.fanhehe.home.system;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service("UserSystemFallback")
public class UserSystemFallback implements UserSystem {
    public String createUser(@RequestParam("phoneRegion")String phoneRegion, @RequestParam("phoneNumber")String phoneNumber) {
        return "create-user-fallback";
    }
}

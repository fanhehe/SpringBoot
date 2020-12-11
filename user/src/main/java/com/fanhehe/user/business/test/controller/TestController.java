package com.fanhehe.user.business.test.controller;

import com.fanhehe.user.business.test.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/9 21:46
 */
@RestController
public class TestController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/test-redis")
    public String testRedis() {
        redisService.testRedis();
        return "xxxxxxxxxx";
    }
}

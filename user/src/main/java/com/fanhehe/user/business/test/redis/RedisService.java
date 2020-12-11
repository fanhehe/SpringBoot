package com.fanhehe.user.business.test.redis;

import com.fanhehe.user.common.result.IResult;
import com.fanhehe.user.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/9 21:42
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public IResult testRedis() {

        redisTemplate.opsForHash().put("key", "field", "value");

        return Result.success();
    }
}

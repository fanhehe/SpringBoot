package com.fanhehe.user.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/10 15:35
 */
public class CacheUtil {
    private static final Cache<String, Integer> cache = CacheBuilder
            .newBuilder()
            .build();

    static {
        cache.put("a", 1);
    }
}

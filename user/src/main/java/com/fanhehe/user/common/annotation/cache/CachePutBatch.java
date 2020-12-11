package com.fanhehe.user.common.annotation.cache;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 15:49
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CachePutBatch {
    @AliasFor("cacheNames")
    String[] value() default {};

    @AliasFor("value")
    String[] cacheNames() default {};

    String key() default "";

    String keyGenerator() default "";

    String cacheManager() default "";

    String cacheResolver() default "";

    String condition() default "";

    String unless() default "";
}


package com.fanhehe.user.config;

import com.fanhehe.user.pojo.PO.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanhehe
 */
@Configuration
public class TestConfiguration {
    @Bean("user")
    public User makeUser() {
        return new User();
    }
}

package com.fanhehe.user.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanhehe
 */
//@Configuration
public class RedissonConfig {
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.cluster.nodes}")
    private String clusters;

//    @Bean
    public RedissonClient getRedisson() {
        String[] nodes = clusters.split(",");
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = "redis://" + nodes[i];
        }
        Config config = new Config();

        config
                .useClusterServers()
                .setScanInterval(2000)
                .addNodeAddress(nodes);
//                .setPassword(password)
        return Redisson.create(config);
    }

}

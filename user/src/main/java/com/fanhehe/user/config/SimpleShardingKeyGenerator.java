package com.fanhehe.user.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/11 12:13
 */
@Configuration
public class SimpleShardingKeyGenerator implements ShardingKeyGenerator {

    private AtomicLong atomic = new AtomicLong(0);
    @Getter
    @Setter
    private Properties properties = new Properties();

    @Override
    public Comparable<?> generateKey() {
        return atomic.incrementAndGet();
    }

    @Override
    public String getType() {
        //声明类型
        return "SIMPLE";
    }
}

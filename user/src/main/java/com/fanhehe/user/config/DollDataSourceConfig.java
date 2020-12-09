package com.fanhehe.user.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/9 09:55
 */
@EnableJpaRepositories(basePackages = {"com.fanhehe.user.business.doll.wave.pojo.repository"})
public class DollDataSourceConfig {

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.shardingsphere.datasource.doll")
    public DataSource dollDataSource() {
        System.out.println("secondary db built");
        return DataSourceBuilder.create().build();
    }
}

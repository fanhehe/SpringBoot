package com.fanhehe.user.config.dataSource;

import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.ShardingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Objects;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/10 11:18
 */
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.fanhehe.user.business.user",
//        entityManagerFactoryRef = "entityManagerFactory",
//        transactionManagerRef = "platformTransactionManager"
//)
public class UserCoreDataSourceConfig {
//
//    @Bean("dollDataSource")
//    @ConfigurationProperties(prefix = "spring.shardingspherex.datasource.doll")
//    public DataSource dollDatasource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Autowired
//    private EntityManagerFactoryBuilder builder;
//
//    @Bean(name = "entityManagerPrimary")
//    public EntityManager entityManager() {
//        return Objects.requireNonNull(dollEntityManagerFactory().getObject()).createEntityManager();
//    }
//
//    @Bean("dollEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean dollEntityManagerFactory() {
//        return builder.dataSource(dollDatasource()).packages("com.fanhehe.user.business.user").build();
//    }
//
//    @Bean("dollPlatformTransactionManager")
//    public PlatformTransactionManager dollPlatformTransactionManager() {
//        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = dollEntityManagerFactory();
//        return new JpaTransactionManager(Objects.requireNonNull(localContainerEntityManagerFactoryBean.getObject()));
//    }
}
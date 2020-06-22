package com.narvik.cloud.index.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.narvik.common.aop.GlobalTransactionAspect;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SeataConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    /**
     * service触发异常时，让全局事务回滚
     * 主要应对当多层服务调用，发生降级等操作时，返回结果不触发错误，导致全局事务没有回滚的情况
     *SeataConfiguration
     * @return
     */
    @Bean
    public GlobalTransactionAspect globalTransactionAspect() {
        return new GlobalTransactionAspect();
    }
}
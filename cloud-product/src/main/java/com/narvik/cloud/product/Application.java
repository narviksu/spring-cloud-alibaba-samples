package com.narvik.cloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author narvik
 * @Date 2020/5/11 18:32
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.narvik.cloud.product.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

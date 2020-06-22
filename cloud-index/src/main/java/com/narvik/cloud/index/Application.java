package com.narvik.cloud.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author narvik
 * @Date 2020/5/11 18:45
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

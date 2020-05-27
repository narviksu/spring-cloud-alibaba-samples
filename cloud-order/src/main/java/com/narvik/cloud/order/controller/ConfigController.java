package com.narvik.cloud.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author narvik
 * @Date 2020/5/11 20:17
 */
@RestController
@RefreshScope
public class ConfigController {
    //@Value("${config.message}")
    private String configMessage;

    @GetMapping("/config/message")
    public String configMessage() {
        return configMessage;
    }
}

package com.narvik.cloud.index.controller;

import com.narvik.cloud.common.entity.CommonResult;
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
    //需要搭建nacos后自己根据官方文档录入config.message才能测试
    //@Value("${config.message}")
    private String configMessage;

    /**
     * 测试nacos-config
     *
     * @return
     */
    @GetMapping("/config/message")
    public CommonResult<String> configMessage() {
        return new CommonResult<>(configMessage);
    }
}

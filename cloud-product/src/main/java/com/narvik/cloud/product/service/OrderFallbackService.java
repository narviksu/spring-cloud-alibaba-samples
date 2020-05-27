package com.narvik.cloud.product.service;

import com.narvik.cloud.common.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/5/8 18:20
 */
@Component
public class OrderFallbackService implements OrderService {

    @Override
    public CommonResult<String> connection() {
        return new CommonResult<>(50010, "服务降级返回", null);
    }
}

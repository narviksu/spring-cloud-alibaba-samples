package com.narvik.cloud.product.service;

import com.narvik.cloud.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(value = "product", fallback = OrderFallbackService.class)
public interface OrderService {

    @GetMapping(value = "/connection")
    CommonResult<String> connection();

}

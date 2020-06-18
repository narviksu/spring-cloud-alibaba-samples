package com.narvik.cloud.product.remote;

import com.narvik.cloud.common.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(qualifier = "orderService", value = "product", fallback = OrderFallback.class)
public interface OrderService {

    @GetMapping(value = "/connection")
    CommonResult<String> connection();

}

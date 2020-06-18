package com.narvik.cloud.index.remote;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.common.entity.dto.OrderCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(qualifier = "orderService", value = "order", fallback = ProductFallback.class)
public interface OrderService {

    @PostMapping(value = "/order")
    CommonResult<Order> createOrder(@RequestBody OrderCreateDto dto);
}

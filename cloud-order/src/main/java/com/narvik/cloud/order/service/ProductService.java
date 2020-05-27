package com.narvik.cloud.order.service;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(value = "product", fallback = ProductFallbackService.class)
public interface ProductService {

    @GetMapping(value = "/connection")
    CommonResult<String> connection();

    @GetMapping(value = "/product/{id}")
    CommonResult<Product> product(@PathVariable("id") Long id);
}

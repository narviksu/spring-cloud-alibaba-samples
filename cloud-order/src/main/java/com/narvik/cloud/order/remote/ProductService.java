package com.narvik.cloud.order.remote;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(qualifier = "productService", value = "product", fallback = ProductFallback.class)
public interface ProductService {

    @GetMapping(value = "/product/{id}")
    CommonResult<Product> product(@PathVariable("id") String id);
    
}

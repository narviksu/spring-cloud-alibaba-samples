package com.narvik.cloud.index.remote;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.dto.ProductStockUpdateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(qualifier = "productService", value = "product", fallback = ProductFallback.class)
public interface ProductService {

    @PutMapping(value = "/product/stock")
    CommonResult<String> updateProductStock(@RequestBody ProductStockUpdateDto dto);
}

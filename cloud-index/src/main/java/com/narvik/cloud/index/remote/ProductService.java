package com.narvik.cloud.index.remote;

import com.narvik.common.entity.CommonResult;
import com.narvik.common.entity.dto.ProductStockUpdateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author narvik
 * @Date 2020/5/8 18:25
 */
@FeignClient(qualifier = "productService", value = "product", fallback = ProductFallback.class)
//@FeignClient(qualifier = "productService", value = "product")
public interface ProductService {

    @PutMapping(value = "/product/stock")
    CommonResult<String> updateProductStock(@RequestBody ProductStockUpdateDto dto);
}

package com.narvik.cloud.order.service;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.constant.ResponseCode;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/5/8 18:20
 */
@Component
public class ProductFallbackService implements ProductService {

    @Override
    public CommonResult<String> connection() {
        return new CommonResult<>(ResponseCode.FEIGN_FALLBACK_ERROR, "服务降级返回", null);
    }

    @Override
    public CommonResult<Product> product(Long id) {
        return new CommonResult<>(ResponseCode.FEIGN_FALLBACK_ERROR, "服务降级返回", null);
    }
}

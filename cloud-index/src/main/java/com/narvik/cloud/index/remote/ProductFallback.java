package com.narvik.cloud.index.remote;

import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.dto.ProductStockUpdateDto;
import com.narvik.cloud.constant.ResponseCode;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/5/8 18:20
 * feign远程调用的兜底方案，跟sentinel不一样的需要注意
 */
@Component
public class ProductFallback implements ProductService {

    @Override
    public CommonResult<String> updateProductStock(ProductStockUpdateDto dto) {
        return new CommonResult<>(ResponseCode.FEIGN_FALLBACK_ERROR, "服务降级返回", null);
    }

}

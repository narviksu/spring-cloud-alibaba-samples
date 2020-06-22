package com.narvik.cloud.product.remote;

import com.narvik.common.entity.CommonResult;
import com.narvik.common.constant.ResponseCode;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/5/8 18:20
 * feign远程调用的兜底方案，跟sentinel不一样的需要注意
 */
@Component
public class OrderFallback implements OrderService {

    @Override
    public CommonResult<String> connection() {
        return new CommonResult<>(ResponseCode.FEIGN_FALLBACK_ERROR, "feign fallback", false, null);
    }
}

package com.narvik.cloud.product.remote;

import com.narvik.cloud.common.entity.CommonResult;
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
        return new CommonResult<>(50010, "服务降级返回", null);
    }
}

package com.narvik.cloud.common.sentinel;

import com.narvik.cloud.common.entity.CommonResult;

/**
 * @Author narvik
 * @Date 2020/6/9 17:59
 * 全局的BlockHandler
 */
public class CommonFallback {

    public static CommonResult<?> fallback() {
        return new CommonResult<>(50000, "fallback by global handler");
    }

}

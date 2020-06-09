package com.narvik.cloud.common.sentinel;

import com.narvik.cloud.common.entity.CommonResult;

/**
 * @Author narvik
 * @Date 2020/6/9 17:59
 * 全局的BlockHandler
 */
public class CommonBlockHandler {

    public static CommonResult<?> handleException() {
        return new CommonResult<>(50000, "blocking by global handler");
    }

}

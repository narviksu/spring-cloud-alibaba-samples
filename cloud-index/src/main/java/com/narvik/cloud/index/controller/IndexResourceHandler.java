package com.narvik.cloud.index.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.dto.PurchaseDto;
import com.narvik.cloud.constant.ResponseCode;

/**
 * @Author narvik
 * @Date 2020/6/9 21:58
 * 降级和熔断相关处理
 * sentinel要求Fallback和BlockHandler函数参数和返回值必须跟原函数一致，并且当函数与原函数不在同一个类时，需要static修饰
 */
public class IndexResourceHandler {

    public static CommonResult<String> handlePurchase(PurchaseDto dto, BlockException exception) {
        return new CommonResult<>(ResponseCode.BLOCK_ERROR, "handlePurchase", null);
    }

    public static CommonResult<String> fallbackPurchase(PurchaseDto dto, Throwable throwable) {
        return new CommonResult<>(ResponseCode.FALLBACK_ERROR, "fallbackPurchase", null);
    }


}

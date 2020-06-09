package com.narvik.cloud.product.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.constant.ResponseCode;

/**
 * @Author narvik
 * @Date 2020/6/9 21:11
 * sentinel要求Fallback和BlockHandler函数参数和返回值必须跟原函数一致，并且当函数与原函数不在同一个类时，需要static修饰
 */
public class ProductHandler {

    public static CommonResult<Product> handleProduct(Long id, BlockException exception) {
        return new CommonResult<>(ResponseCode.BLOCK_ERROR, "handleProduct", null);
    }

    public static CommonResult<Product> fallbackProduct(Long id, Throwable throwable) {
        return new CommonResult<>(ResponseCode.FALLBACK_ERROR, "fallbackProduct", null);
    }

}

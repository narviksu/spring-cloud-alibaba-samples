package com.narvik.cloud.product.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.common.entity.dto.ProductStockUpdateDto;
import com.narvik.cloud.constant.ResponseCode;

/**
 * @Author narvik
 * @Date 2020/6/9 21:11
 * 降级和熔断相关处理
 * sentinel要求Fallback和BlockHandler函数参数和返回值必须跟原函数一致，并且当函数与原函数不在同一个类时，需要static修饰
 */
public class ProductResourceHandler {

    public static CommonResult<Product> handleGetProduct(String id, BlockException exception) {
        return new CommonResult<>(ResponseCode.BLOCK_ERROR, "handle", null);
    }

    public static CommonResult<Product> fallbackGetProduct(String id, Throwable throwable) {
        return new CommonResult<>(ResponseCode.FALLBACK_ERROR, "fallback", null);
    }


    public static CommonResult<String> handleUpdateProductStock(ProductStockUpdateDto dto, BlockException exception) {
        return new CommonResult<>(ResponseCode.BLOCK_ERROR, "handle", null);
    }

    public static CommonResult<String> fallbackUpdateProductStock(ProductStockUpdateDto dto, Throwable throwable) {
        return new CommonResult<>(ResponseCode.FALLBACK_ERROR, "fallback", null);
    }
}

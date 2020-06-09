package com.narvik.cloud.order.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.constant.ResponseCode;

/**
 * @Author narvik
 * @Date 2020/6/9 21:58
 */
public class OrderHandler extends BaseController {

    public static CommonResult<Product> handleOrder(Long id, BlockException exception) {
        return new CommonResult<>(ResponseCode.BLOCK_ERROR, "handleOrder", null);
    }

    public static CommonResult<Product> fallbackOrder(Long id, Throwable throwable) {
        return new CommonResult<>(ResponseCode.FALLBACK_ERROR, "fallbackOrder", null);
    }


}

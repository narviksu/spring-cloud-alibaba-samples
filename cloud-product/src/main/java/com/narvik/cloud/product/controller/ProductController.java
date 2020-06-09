package com.narvik.cloud.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.collect.Maps;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.common.sentinel.CommonBlockHandler;
import com.narvik.cloud.common.sentinel.CommonFallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author narvik
 * @Date 2020/5/8 18:11
 */
@RestController
public class ProductController extends BaseController {

    @GetMapping(value = "/product/{id}")
    @SentinelResource(value = "product", blockHandlerClass = CommonBlockHandler.class, blockHandler = "handleException", fallbackClass = CommonFallback.class, fallback = "fallback")
    public CommonResult<Product> product(@PathVariable("id") Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("cola");
        return new CommonResult<Product>(200, "success", product);
    }

}

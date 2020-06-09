package com.narvik.cloud.product.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author narvik
 * @Date 2020/5/8 18:11
 */
@RestController
public class ProductController extends BaseController {

    @GetMapping(value = "/product/{id}")
    @SentinelResource(value = "product", blockHandlerClass = ProductHandler.class, blockHandler = "handleProduct", fallbackClass = ProductHandler.class, fallback = "fallbackProduct")
    public CommonResult<Product> product(@PathVariable("id") Long id) {
        //测试sentinel fallback
        if (id > 3) {
            throw new IllegalArgumentException("error");
        }
        Product product = new Product();
        product.setId(id);
        product.setName("cola");
        return new CommonResult<Product>(200, "success", product);
    }

}

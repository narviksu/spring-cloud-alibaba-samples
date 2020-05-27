package com.narvik.cloud.product.controller;

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
    public CommonResult<Product> product(@PathVariable("id") Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("cola");
        return new CommonResult<Product>(200, "success", product);
    }

}

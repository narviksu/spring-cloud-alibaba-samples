package com.narvik.cloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.common.sentinel.CommonBlockHandler;
import com.narvik.cloud.common.sentinel.CommonFallback;
import com.narvik.cloud.order.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author narvik
 * @Date 2020/5/8 18:11
 */
@RestController
public class OrderController extends BaseController {
    @Resource
    private ProductService productService;

    @GetMapping(value = "/order/{id}")
    @SentinelResource(value = "order", blockHandlerClass = CommonBlockHandler.class, blockHandler = "handleException", fallbackClass = CommonFallback.class, fallback = "fallback")
    public CommonResult<Order> order(@PathVariable("id") Long id) {
        Order order = new Order();
        order.setId(id);
        order.setProductList(new ArrayList<>());
        order.getProductList().add(productService.product(id).getData());
        return new CommonResult<>(order);
    }

}

package com.narvik.cloud.order.controller;

import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/order/{id}")
    public CommonResult<Order> order(@PathVariable("id") Long id) {
        Order order = new Order();
        order.setId(id);
        order.setProductList(new ArrayList<>());
        order.getProductList().add(productService.product(id).getData());
        return new CommonResult<>(order);
    }

}

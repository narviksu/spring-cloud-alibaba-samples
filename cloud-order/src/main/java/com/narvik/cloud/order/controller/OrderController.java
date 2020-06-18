package com.narvik.cloud.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.narvik.cloud.base.BaseController;
import com.narvik.cloud.common.entity.CommonResult;
import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.common.entity.dto.OrderCreateDto;
import com.narvik.cloud.order.remote.ProductService;
import com.narvik.cloud.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

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
    private OrderService orderService;

    /**
     * 根据订单id获取指定的订单
     *
     * @param id 订单id
     * @return 订单实体
     */
    @GetMapping(value = "/order/{id}")
    @SentinelResource(value = "getOrder", blockHandlerClass = OrderResourceHandler.class, blockHandler = "handleGetOrder", fallbackClass = OrderResourceHandler.class, fallback = "fallbackGetOrder")
    public CommonResult<Order> getOrder(@PathVariable("id") String id) {
        Order order = new Order();
        order.setId(id);
        order.setProductList(new ArrayList<>());
        order.getProductList().add(productService.product(id).getData());
        return new CommonResult<>(order);
    }

    /**
     * 创建订单
     *
     * @param dto 创建订单所需参数，详情看class
     * @return 创建的订单相关信息
     */
    @PostMapping(value = "/order")
    @SentinelResource(value = "createOrder", blockHandlerClass = OrderResourceHandler.class, blockHandler = "handleCreateOrder", fallbackClass = OrderResourceHandler.class, fallback = "fallbackCreateOrder")
    public CommonResult<Order> createOrder(@RequestBody OrderCreateDto dto) {
        return new CommonResult<>(orderService.createOrder(dto.getUserId(), dto.getProductIds()));
    }

}

package com.narvik.cloud.order.service;

import com.narvik.cloud.common.entity.Order;

import java.util.List;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
public interface OrderService {

    Order createOrder(String userId, List<String> productIds);

}

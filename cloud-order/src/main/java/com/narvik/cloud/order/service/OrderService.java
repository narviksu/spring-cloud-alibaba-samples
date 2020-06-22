package com.narvik.cloud.order.service;

import com.narvik.common.entity.Order;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
public interface OrderService {

    Order createOrder(String userId, Map<String, Integer> productDetailMap);

}

package com.narvik.cloud.order.service;

import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.constant.TestResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(String userId, List<String> productIds) {
        //传0时，抛出异常，用于测试seata或者sentinel
        if ("1".equals(userId)) {
            throw new IllegalArgumentException("test error");
        }
        Order order = new Order();
        order.setId("1");
        order.setProductList(new ArrayList<>());
        //查询商品信息
        for (String productId : productIds) {
            order.getProductList().add(TestResources.TEST_PRODUCTS.get(productId));
        }
        return order;
    }
}

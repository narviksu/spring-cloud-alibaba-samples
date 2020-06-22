package com.narvik.common.constant;

import com.narvik.common.entity.Order;
import com.narvik.common.entity.Product;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/9 22:10
 * 测试数据
 */
public class TestResources {
    public static Map<String, Product> TEST_PRODUCTS;//商品
    public static Map<String, Order> TEST_ORDERS;//订单

    static {
        TEST_PRODUCTS.put("1", new Product("1", "cola", BigDecimal.valueOf(3.5), 4));
        TEST_PRODUCTS.put("2", new Product("2", "milk", BigDecimal.valueOf(6.5), 5));
        TEST_PRODUCTS.put("3", new Product("3", "coffee", BigDecimal.valueOf(8.5), 6));
    }
}

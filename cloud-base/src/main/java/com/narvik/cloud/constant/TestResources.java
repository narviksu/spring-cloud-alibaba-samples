package com.narvik.cloud.constant;

import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.common.entity.Product;
import com.narvik.cloud.common.entity.ProductPrice;
import com.narvik.cloud.common.entity.ProductStock;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/9 22:10
 * 测试数据
 */
public class TestResources {
    public static Map<String, Product> TEST_PRODUCTS;//商品
    public static Map<String, ProductPrice> TEST_PRODUCT_PRICE_INFOS;//价格
    public static Map<String, ProductStock> TEST_PRODUCT_STOCK_INFOS;//库存
    public static Map<String, Order> TEST_ORDERS;//订单

    static {
        TEST_PRODUCTS.put("1", new Product("1", "cola"));
        TEST_PRODUCTS.put("2", new Product("2", "milk"));
        TEST_PRODUCTS.put("3", new Product("3", "coffee"));

        TEST_PRODUCT_PRICE_INFOS.put("1", new ProductPrice("1", BigDecimal.valueOf(3)));
        TEST_PRODUCT_PRICE_INFOS.put("2", new ProductPrice("2", BigDecimal.valueOf(6)));
        TEST_PRODUCT_PRICE_INFOS.put("3", new ProductPrice("3", BigDecimal.valueOf(9)));

        TEST_PRODUCT_STOCK_INFOS.put("1", new ProductStock("1", 4));
        TEST_PRODUCT_STOCK_INFOS.put("2", new ProductStock("2", 5));
        TEST_PRODUCT_STOCK_INFOS.put("3", new ProductStock("3", 6));
    }
}

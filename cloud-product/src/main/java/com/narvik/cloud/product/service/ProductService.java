package com.narvik.cloud.product.service;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/16 18:38
 */
public interface ProductService {
    String updateProductStock(String userId, Map<String, Integer> stockChangeMap);
}

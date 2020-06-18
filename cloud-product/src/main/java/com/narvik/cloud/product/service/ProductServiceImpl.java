package com.narvik.cloud.product.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/16 18:38
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String updateProductStock(String userId, Map<String, Integer> stockChangeMap) {
        //测试seata
        if ("0".equals(userId)) {
            throw new IllegalArgumentException("test error");
        }
        return "更新库存成功";
    }
}

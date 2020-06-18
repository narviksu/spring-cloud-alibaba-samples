package com.narvik.cloud.common.entity.dto;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
public class ProductStockUpdateDto {
    private String userId;
    /**
     * key商品id
     * value商品库存增量，区分正负数
     */
    private Map<String, Integer> stockChangeMap;

    public Map<String, Integer> getStockChangeMap() {
        return stockChangeMap;
    }

    public void setStockChangeMap(Map<String, Integer> stockChangeMap) {
        this.stockChangeMap = stockChangeMap;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

package com.narvik.common.entity.dto;

import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
public class OrderCreateDto {
    private String userId;
    /**
     * key商品id
     * value商品数量，正整数
     */
    private Map<String, Integer> productDetailMap;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Integer> getProductDetailMap() {
        return productDetailMap;
    }

    public void setProductDetailMap(Map<String, Integer> productDetailMap) {
        this.productDetailMap = productDetailMap;
    }
}

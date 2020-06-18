package com.narvik.cloud.common.entity.dto;

import java.util.List;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
public class OrderCreateDto {
    private String userId;
    private List<String> productIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}

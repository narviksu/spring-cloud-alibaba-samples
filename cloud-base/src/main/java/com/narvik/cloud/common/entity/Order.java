package com.narvik.cloud.common.entity;

import java.util.List;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
public class Order {
    private Long id;
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

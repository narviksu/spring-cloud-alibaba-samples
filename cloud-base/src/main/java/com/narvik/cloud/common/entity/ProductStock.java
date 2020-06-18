package com.narvik.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
@TableName("`product_stock`")
public class ProductStock {
    private String id;
    private String productId;
    private Integer stock;

    public ProductStock() {
    }

    public ProductStock(String id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

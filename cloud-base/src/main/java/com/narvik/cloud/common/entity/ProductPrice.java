package com.narvik.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
@TableName("`product_price`")
public class ProductPrice {
    private String id;
    private String productId;
    private BigDecimal price;

    public ProductPrice() {
    }

    public ProductPrice(String id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}

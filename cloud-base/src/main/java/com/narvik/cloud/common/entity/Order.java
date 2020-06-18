package com.narvik.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
@TableName("`order`")
public class Order {
    private String id;
    @TableField(exist = false)
    private List<Product> productList;

    public Order() {
    }

    public Order(String id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

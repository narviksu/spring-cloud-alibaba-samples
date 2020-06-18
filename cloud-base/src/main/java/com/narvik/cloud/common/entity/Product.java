package com.narvik.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
@TableName("`product`")
public class Product {
    private String id;
    private String name;

    public Product() {
    }

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

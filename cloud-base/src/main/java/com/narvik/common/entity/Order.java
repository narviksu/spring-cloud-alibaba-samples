package com.narvik.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;

import java.util.List;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/5/11 18:40
 */
@TableName("`order`")
public class Order {
    @TableId(type = IdType.AUTO)
    private String id;
    private String serialNumber;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Integer> productDetailMap;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Map<String, Integer> getProductDetailMap() {
        return productDetailMap;
    }

    public void setProductDetailMap(Map<String, Integer> productDetailMap) {
        this.productDetailMap = productDetailMap;
    }
}

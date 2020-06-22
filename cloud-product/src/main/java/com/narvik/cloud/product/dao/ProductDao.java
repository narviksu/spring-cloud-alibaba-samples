package com.narvik.cloud.product.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.narvik.cloud.product.mapper.ProductMapper;
import com.narvik.common.entity.Product;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/6/18 22:24
 */
@Component
public class ProductDao extends ServiceImpl<ProductMapper, Product> implements IService<Product> {
}

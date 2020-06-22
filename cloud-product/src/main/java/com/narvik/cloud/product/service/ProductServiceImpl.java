package com.narvik.cloud.product.service;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.narvik.common.entity.Product;
import com.narvik.cloud.product.dao.ProductDao;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @Author narvik
 * @Date 2020/6/16 18:38
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public String updateProductStock(String userId, Map<String, Integer> stockChangeMap) {
        //测试seata
        if ("0".equals(userId)) {
            throw new IllegalArgumentException("test error");
        }
        Set<String> ids = stockChangeMap.keySet();
        List<Product> productList = productDao.listByIds(ids);
        Map<String, Product> productMap = Maps.uniqueIndex(productList, new Function<Product, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Product productStock) {
                return Objects.requireNonNull(productStock).getId();
            }
        });
        stockChangeMap.forEach((s, integer) -> {
            Product product = productMap.get(s);
            if (product == null) {
                throw new RuntimeException("找不到该商品");
            }
            int stock = product.getStock() + integer;
            if (stock < 0) {
                throw new RuntimeException("库存不能小于0");
            }
            product.setStock(stock);
        });
        productDao.updateBatchById(productMap.values());
        return "更新库存成功";
    }
}

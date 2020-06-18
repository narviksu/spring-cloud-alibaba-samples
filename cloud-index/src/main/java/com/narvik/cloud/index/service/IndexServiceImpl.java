package com.narvik.cloud.index.service;

import com.narvik.cloud.common.entity.dto.OrderCreateDto;
import com.narvik.cloud.common.entity.dto.ProductStockUpdateDto;
import com.narvik.cloud.index.remote.OrderService;
import com.narvik.cloud.index.remote.ProductService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Resource
    OrderService orderService;
    @Resource
    ProductService productService;

    @GlobalTransactional
    @Override
    public String purchase(String userId, Map<String, Integer> stockChangeMap) {
        //扣库存
        ProductStockUpdateDto productStockUpdateDto = new ProductStockUpdateDto();
        productStockUpdateDto.setUserId(userId);
        productStockUpdateDto.setStockChangeMap(stockChangeMap);
        productService.updateProductStock(productStockUpdateDto);
        //创建订单
        OrderCreateDto orderCreateDto = new OrderCreateDto();
        orderCreateDto.setUserId(userId);
        orderCreateDto.setProductIds(new ArrayList<>(stockChangeMap.keySet()));
        orderService.createOrder(orderCreateDto);
        //测试，省略支付等步骤...
        return "购买成功";
    }
}
package com.narvik.cloud.index.service;

import com.google.common.collect.Maps;
import com.narvik.cloud.index.remote.OrderService;
import com.narvik.cloud.index.remote.ProductService;
import com.narvik.common.entity.CommonResult;
import com.narvik.common.entity.Order;
import com.narvik.common.entity.dto.OrderCreateDto;
import com.narvik.common.entity.dto.ProductStockUpdateDto;
import com.narvik.util.AssertUtils;
import com.narvik.util.JsonUtils;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
@Service
public class IndexServiceImpl implements IndexService {
    private final static Logger logger = LoggerFactory.getLogger(IndexService.class);
    @Resource
    OrderService orderService;
    @Resource
    ProductService productService;

    @GlobalTransactional
    @Override
    public String purchase(String userId, Map<String, Integer> productDetailMap) {
        //扣库存
        Map<String, Integer> stockChangeMap = Maps.transformEntries(productDetailMap, new Maps.EntryTransformer<String, Integer, Integer>() {
            @Override
            public Integer transformEntry(@Nullable String s, @Nullable Integer integer) {
                //修改库存区分正负，购买商品数量为正数需要把正数转为负数
                return integer == null ? null : -integer;
            }
        });
        ProductStockUpdateDto productStockUpdateDto = new ProductStockUpdateDto();
        productStockUpdateDto.setUserId(userId);
        productStockUpdateDto.setStockChangeMap(stockChangeMap);
        CommonResult<String> result1 = productService.updateProductStock(productStockUpdateDto);
        logger.info("result1={}", JsonUtils.bean2Json(result1));
        AssertUtils.checkFalse(result1.isStatus(), "购买失败，无法扣减库存");
        OrderCreateDto orderCreateDto = new OrderCreateDto();
        orderCreateDto.setUserId(userId);
        orderCreateDto.setProductDetailMap(productDetailMap);
        CommonResult<Order> result2 = orderService.createOrder(orderCreateDto);
        logger.info("result2={}", JsonUtils.bean2Json(result2));
        AssertUtils.checkFalse(result2.isStatus(), "购买失败，无法创建订单");
        //测试，省略支付等步骤...
        return "购买成功";
    }
}
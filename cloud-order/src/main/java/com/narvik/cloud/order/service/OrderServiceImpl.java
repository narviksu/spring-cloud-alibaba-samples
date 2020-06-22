package com.narvik.cloud.order.service;

import com.narvik.common.entity.Order;
import com.narvik.cloud.order.dao.OrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Author narvik
 * @Date 2020/6/13 20:03
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public Order createOrder(String userId, Map<String, Integer> productDetailMap) {
        //传0时，抛出异常，用于测试seata或者sentinel
        if ("1".equals(userId)) {
            throw new IllegalArgumentException("test error");
        }
        Order order = new Order();
        order.setProductDetailMap(productDetailMap);
        order.setSerialNumber(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        boolean isSuccess = orderDao.save(order);
        if (!isSuccess) {
            throw new RuntimeException("save error");
        }
        return order;
    }
}

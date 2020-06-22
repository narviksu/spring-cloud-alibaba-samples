package com.narvik.cloud.order.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.narvik.common.entity.Order;
import com.narvik.cloud.order.mapper.OrderMapper;
import org.springframework.stereotype.Component;

/**
 * @Author narvik
 * @Date 2020/6/18 22:22
 */
@Component
public class OrderDao extends ServiceImpl<OrderMapper, Order> implements IService<Order> {

}

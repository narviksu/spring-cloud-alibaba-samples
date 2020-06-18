package com.narvik.cloud.order.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.narvik.cloud.common.entity.Order;
import com.narvik.cloud.order.mapper.OrderMapper;

/**
 * @Author narvik
 * @Date 2020/6/18 22:22
 */
public class OrderDao extends ServiceImpl<OrderMapper, Order> implements IService<Order> {

}

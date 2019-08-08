package com.eshop.service;

import com.eshop.entity.Order;

import java.util.List;

/**
 * 查询订单接口
 */
public interface QueryOrderService {
    public List<Order> queryOrder(int...number);
}

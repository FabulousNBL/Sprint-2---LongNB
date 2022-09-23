package com.project.service;

import com.project.dto.OrderDto;
import com.project.model.CartDto;
import com.project.model.Order;
import com.project.model.Product;

import java.util.List;

public interface IOrderService {
    void saveOrder(List<CartDto> cartDtoList);
    void createOrder(OrderDto orderDto);
    List<Order> getListOrder();
}

package com.quicksilvarad.jmeterTest.service;

import com.quicksilvarad.jmeterTest.dto.OrderDTO;
import com.quicksilvarad.jmeterTest.entity.Order;
import com.quicksilvarad.jmeterTest.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(OrderDTO orderDTO)
    {
        Order order = new Order();

        order.setCustomerName(orderDTO.getCustomer_name());
        order.setEmail(orderDTO.getEmail());
        order.setAddress(orderDTO.getAddress());
        order.setLastName(orderDTO.getLast_name());
        order.setItemQty(orderDTO.getItem_qty());

        return orderRepository.save(order);
    }

    public Order getOrder(UUID orderId)
    {
        return orderRepository.findOrderByOrderId(orderId);
    }
}

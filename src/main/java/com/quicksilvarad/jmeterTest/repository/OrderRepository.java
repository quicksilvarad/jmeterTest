package com.quicksilvarad.jmeterTest.repository;

import com.quicksilvarad.jmeterTest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    public Order save(Order OrderDTO);
    public Order findOrderByOrderId(UUID orderId);
}

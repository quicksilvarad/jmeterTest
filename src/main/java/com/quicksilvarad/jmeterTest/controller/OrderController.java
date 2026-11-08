package com.quicksilvarad.jmeterTest.controller;

import com.quicksilvarad.jmeterTest.entity.Order;
import com.quicksilvarad.jmeterTest.mapper.OrderMapper;
import com.quicksilvarad.jmeterTest.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody String order)
    {
        OrderMapper orderMapper = new OrderMapper();
       Order saveOrder= orderService.createOrder(orderMapper.convertToDTO(order));
       Logger logger = LoggerFactory.getLogger(OrderController.class);
       logger.trace("Order ID: "+ saveOrder.getOrderId()+"Customer Name: "+ saveOrder.getCustomerName());
       return ResponseEntity.status(HttpStatus.CREATED).body("Order created Successfully! \n Your Order Number is : " + saveOrder.getOrderId()+"\n Customer Name: "+ saveOrder.getCustomerName());

    }

    @GetMapping(value = "/get",params = "orderId")
    public ResponseEntity<String> getOrder(@RequestParam String orderId)
    {
        Order savedOrder = orderService.getOrder(UUID.fromString(orderId));
        return ResponseEntity.status(HttpStatus.OK).body(
                "OrderID: "+ savedOrder.getOrderId()+"\n Customer Name: "+savedOrder.getCustomerName()
                +"\n LastName: "+savedOrder.getLastName()+"\n Email: "+savedOrder.getEmail()+"\n Address: "+ savedOrder.getAddress()+
                "\n Item_qty: "+ savedOrder.getItemQty());
    }
}

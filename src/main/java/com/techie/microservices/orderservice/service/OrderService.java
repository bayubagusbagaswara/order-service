package com.techie.microservices.orderservice.service;

import com.techie.microservices.orderservice.dto.OrderRequest;
import com.techie.microservices.orderservice.model.Order;
import com.techie.microservices.orderservice.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(request.price());
        order.setSkuCode(request.skuCode());
        order.setQuantity(request.quantity());

        orderRepository.save(order);
    }

}

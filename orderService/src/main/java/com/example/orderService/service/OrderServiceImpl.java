package com.example.orderService.service;

import com.example.orderService.dto.OrderRequestDto;
import com.example.orderService.dto.OrderResponseDto;
import com.example.orderService.repository.OrderItemRepository;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;


    @Override
    public String deleteOrder(String orderId) {
        return "";
    }

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        // Generate order ID
        String orderId = generateOrderId();



        // validate the products
        // check the inventory
        // save order and order items
        // return response
        return null;
    }

    @Override
    public OrderResponseDto getOrderById(String orderId) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrder() {
        return List.of();
    }

    @Override
    public OrderResponseDto updateOrder(String orderId, String status) {
        return null;
    }


    // generate unique order id
    private String generateOrderId() {
        return "ORD-" + UUID.randomUUID().toString().substring(0, 8);
    }

    private String generateOrderItemId() {
        return "ITEM-" + UUID.randomUUID().toString().substring(0, 8);
    }


}

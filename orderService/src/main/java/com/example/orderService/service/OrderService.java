package com.example.orderService.service;

import com.example.orderService.dto.OrderRequestDto;
import com.example.orderService.dto.OrderResponseDto;
import com.example.orderService.repository.OrderItemRepository;
import com.example.orderService.repository.OrderRepository;

import java.util.List;


public interface OrderService {

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto);
    public OrderResponseDto getOrderById(String orderId);
    public List<OrderResponseDto> getOrdersByCustomerId(String customerId);
    public List<OrderResponseDto> getAllOrder();
    public OrderResponseDto updateOrder(String orderId, String status);
    public String deleteOrder(String orderId);
}

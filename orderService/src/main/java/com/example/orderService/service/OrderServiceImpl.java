package com.example.orderService.service;

import com.example.orderService.dto.OrderResponseDto;
import com.example.orderService.repository.OrderItemRepository;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public OrderResponseDto placeOrder(String userId) {
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


}

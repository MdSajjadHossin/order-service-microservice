package com.example.orderService.service;

import com.example.orderService.dto.*;
import com.example.orderService.entity.Order;
import com.example.orderService.entity.OrderItem;
import com.example.orderService.repository.OrderItemRepository;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductClient productClient;


    @Override
    public String deleteOrder(String orderId) {
        return "";
    }

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) {
        // Generate order ID
        String orderId = generateOrderId();
        double totalAmount = 0.0;

        // Calculate total amount
        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequestDto itemRequest : orderRequestDto.getItems()){
            ProductResponseDto productResponseDto = productClient.getProductName(itemRequest.getProductId());
            if(productResponseDto.getStockQuantity() < itemRequest.getQuantity()){
                throw new RuntimeException("Product stock out : " + itemRequest.getProductId());
            }
            productClient.updateProductStock(itemRequest.getProductId(), -itemRequest.getQuantity());

            double itemTotal = productResponseDto.getPrice() * itemRequest.getQuantity();
            totalAmount += itemTotal;

            OrderItem orderItem = new OrderItem(
                    generateOrderItemId(),
                    orderId,
                    itemRequest.getProductId(),
                    itemRequest.getQuantity(),
                    productResponseDto.getPrice());
            orderItems.add(orderItem);
        }

        Order order = new Order(orderId, orderRequestDto.getCustomerId(), totalAmount, OrderStatus.PENDING, LocalDateTime.now());
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItems);

        return new OrderResponseDto(
                orderId,
                orderRequestDto.getCustomerId(),
                totalAmount, OrderStatus.PENDING.name(),
                LocalDateTime.now(),
                orderItems);
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

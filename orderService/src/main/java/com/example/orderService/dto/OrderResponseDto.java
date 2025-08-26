package com.example.orderService.dto;

import com.example.orderService.entity.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {
    private String orderId;
    private String customerId;
    private Double totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;
    private List<OrderItem> items;
}

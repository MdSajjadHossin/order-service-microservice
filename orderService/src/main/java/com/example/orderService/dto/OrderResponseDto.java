package com.example.orderService.dto;

import com.example.orderService.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private String orderId;
    private String customerId;
    private Double totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;
    private List<OrderItem> items;
}

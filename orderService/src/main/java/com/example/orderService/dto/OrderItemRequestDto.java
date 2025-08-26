package com.example.orderService.dto;

import lombok.Data;

@Data
public class OrderItemRequestDto {

    private String productId;
    private Integer quantity;
}

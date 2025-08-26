package com.example.orderService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private String orderId;
    private String customerId;
    private Double totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;

}

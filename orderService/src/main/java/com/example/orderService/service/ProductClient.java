package com.example.orderService.service;

import com.example.orderService.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate;

    public ProductClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ProductResponseDto getProductName(String productId) {
        String url = "http://localhost:6000/products/" + productId;
        return restTemplate.getForObject(url, ProductResponseDto.class);
    }

    public void updateProductStock(String productId, int quantity) {
        String url = "http://localhost:6000/products/" + productId + "/stock?quantity=" + quantity;
        restTemplate.patchForObject(url, quantity, Void.class);
    }
}

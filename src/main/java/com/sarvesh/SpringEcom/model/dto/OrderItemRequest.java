package com.sarvesh.SpringEcom.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}

package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.order.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {

    private String productName;
    private int quantity;

    private OrderItemDto(){}

    public OrderItemDto(OrderItem orderItem) {

        this.productName = orderItem.getProduct().getName();
        this.quantity = orderItem.getQuantity();
    }




}

package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.order.Order;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderDto {


    private Long id;
    private String status;
    private String customerName;
    private String productName;
    private int quantity;
    private BigDecimal totalPrice;

    public OrderDto(Order order){

        this.id = order.getId();
        this.status = order.getStatus().name();
        this.customerName = order.getCustomer().getName();
        this.productName = order.getItems().get(0).getProduct().getName();
        this.quantity = order.getItems().get(0).getQuantity();
        this.totalPrice = order.getTotal();
    }
}

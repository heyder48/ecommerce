package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.order.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDto {


    private Long id;
    private String status;
    private String customerName;
    private List<OrderItemDto> items;
    private BigDecimal totalPrice;

    public OrderDto(Order order){

        this.id = order.getId();
        this.status = order.getStatus().name();
        this.customerName = order.getCustomer().getName();
        this.items = order.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
        this.totalPrice = order.getTotal();

    }

}

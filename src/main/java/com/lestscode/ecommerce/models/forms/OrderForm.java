package com.lestscode.ecommerce.models.forms;

import lombok.Data;

import java.util.List;

@Data
public class OrderForm {

    private Long customerId;
    private List<OrderItemForm> items;

}

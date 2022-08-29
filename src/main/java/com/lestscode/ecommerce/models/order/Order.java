package com.lestscode.ecommerce.models.order;

import com.lestscode.ecommerce.models.customer.Customer;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;
    private List<OrderItem> items;
    private OrderStatus status;
    private Customer customer;
    private BigDecimal total;

    public Order(){}

    public Order(List<OrderItem> items, Customer customer, BigDecimal total) {

        this.items = items;
        this.status = OrderStatus.CREATED;
        this.customer = customer;
        this.total = total;
    }


}

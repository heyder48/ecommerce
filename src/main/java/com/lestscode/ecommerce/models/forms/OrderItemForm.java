package com.lestscode.ecommerce.models.forms;

import com.lestscode.ecommerce.models.order.Order;
import com.lestscode.ecommerce.models.order.OrderItem;
import com.lestscode.ecommerce.models.product.Product;
import lombok.Data;

@Data
public class OrderItemForm {

    private Long productId;
    private int quantity;

    public OrderItemForm(){}


}

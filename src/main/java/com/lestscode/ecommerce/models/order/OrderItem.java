package com.lestscode.ecommerce.models.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lestscode.ecommerce.models.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;
    @Column(nullable = false)

    private Integer quantity;

    public OrderItem(){}

    public OrderItem(Order order, Product product, int quantity) {
        this.pk = new OrderProductPK(order, product);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct(){
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice(){
        return getProduct().getPrice().doubleValue() * quantity;
    }






}

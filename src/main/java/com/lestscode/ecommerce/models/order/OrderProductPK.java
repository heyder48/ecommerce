package com.lestscode.ecommerce.models.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lestscode.ecommerce.models.product.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class OrderProductPK  implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @Getter @Setter
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Getter @Setter
    private Product product;

    public OrderProductPK(){}

    public OrderProductPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}

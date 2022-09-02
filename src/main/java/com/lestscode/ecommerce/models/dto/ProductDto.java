package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductDto {

    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private BigDecimal price;

    public ProductDto(){}

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}

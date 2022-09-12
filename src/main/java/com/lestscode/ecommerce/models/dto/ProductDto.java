package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.product.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Data
public class ProductDto {


    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String CategoriaName;

    public ProductDto(){}

    public ProductDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.CategoriaName = product.getCategoria().getName();
    }
}

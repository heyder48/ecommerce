package com.lestscode.ecommerce.models.product;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @OneToOne
    private Categoria categoria;

    public Product(){}

    public Product( String name, String description, Double price) {

        this.name = name;
        this.description = description;
        this.price = BigDecimal.valueOf(price);
    }


}

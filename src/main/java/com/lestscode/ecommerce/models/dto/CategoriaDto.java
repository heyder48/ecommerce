package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.product.Categoria;
import lombok.Data;

@Data
public class CategoriaDto {

    private Long id;
    private String name;

    public CategoriaDto(){}

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.name = categoria.getName().toString();
    }
}

package com.lestscode.ecommerce.models.product;

import com.lestscode.ecommerce.models.forms.CategoriaForm;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Categoria(){}
    public Categoria(CategoriaForm categoriaForm) {
        this.name = categoriaForm.getName();
    }
}

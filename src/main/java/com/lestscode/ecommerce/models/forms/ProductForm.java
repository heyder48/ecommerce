package com.lestscode.ecommerce.models.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Basic;
@Data
public class ProductForm {

    @NotNull
    @Basic(optional = false)

    private String name;
    @NotNull

    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Long categoriaId;

    public ProductForm(){}


}

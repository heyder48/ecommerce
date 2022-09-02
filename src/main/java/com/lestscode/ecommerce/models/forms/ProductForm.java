package com.lestscode.ecommerce.models.forms;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Basic;

public class ProductForm {

    @NotNull
    @Basic(optional = false)
    @Getter
    @Setter
    private String name;
    @NotNull
    @Getter
    @Setter
    private String description;
    @NotNull
    @Getter
    @Setter
    private Double price;

    public ProductForm(){}


}

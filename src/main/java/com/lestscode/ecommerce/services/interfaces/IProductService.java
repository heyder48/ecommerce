package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.ProductDto;
import com.lestscode.ecommerce.models.forms.ProductForm;

import java.util.List;

public interface IProductService {

    List<ProductDto> listAll();

    ProductDto getById(Long id);

    ProductDto create(ProductForm form);

    ProductDto update(Long id, ProductForm form);

    void delete(Long id);
}

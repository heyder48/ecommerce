package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.CategoriaDto;
import com.lestscode.ecommerce.models.dto.ProductDto;
import com.lestscode.ecommerce.models.forms.CategoriaForm;
import com.lestscode.ecommerce.models.forms.ProductForm;

import java.util.List;

public interface IProductService {

    List<ProductDto> listAll();

    ProductDto getById(Long id);

    ProductDto create(ProductForm form);

    ProductDto update(Long id, ProductForm form);

    void delete(Long id);

    List<CategoriaDto> listAllCategories();

    CategoriaDto getCategoryById(Long id);

    CategoriaDto createCategory(CategoriaForm form);

    CategoriaDto updateCategory(Long id, CategoriaForm form);

    void deleteCategory(Long id);
}

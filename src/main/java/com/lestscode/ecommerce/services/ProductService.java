package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.dto.ProductDto;
import com.lestscode.ecommerce.models.forms.ProductForm;
import com.lestscode.ecommerce.models.product.Product;
import com.lestscode.ecommerce.repositories.ProductRepository;
import com.lestscode.ecommerce.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<ProductDto> listAll() {

        return productRepository.findAll()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(Long id) {

        return new ProductDto(productRepository.findById(id).get());

    }

    @Override
    public ProductDto create(ProductForm form) {

        Product product = new Product(form.getName(), form.getDescription(), form.getPrice());
        productRepository.save(product);

        return new ProductDto(product);
    }

    @Override
    public ProductDto update(Long id, ProductForm form) {

        Product product = productRepository.findById(id).get();

        if (form.getName() != null) {
            product.setName(form.getName());
        }
        if (form.getDescription() != null) {
            product.setDescription(form.getDescription());
        }
        if (form.getPrice() != null) {
            product.setPrice(BigDecimal.valueOf(form.getPrice()));
        }

        return new ProductDto(product);
    }

    @Override
    public void delete(Long id) {

        productRepository.deleteById(id);

    }
}
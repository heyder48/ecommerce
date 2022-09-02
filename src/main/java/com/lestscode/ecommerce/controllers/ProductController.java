package com.lestscode.ecommerce.controllers;

import com.lestscode.ecommerce.models.dto.ProductDto;
import com.lestscode.ecommerce.models.forms.ProductForm;
import com.lestscode.ecommerce.models.product.Product;
import com.lestscode.ecommerce.repositories.ProductRepository;
import com.lestscode.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductDto>> listAll(){

        return ResponseEntity.ok(productService.listAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id){

        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(productService.getById(id));
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> create(@RequestBody ProductForm form){

        ProductDto productDto = productService.create(form);
        URI uri = URI.create("/products/" + productDto.getId());
        return ResponseEntity.created(uri).body(productDto);


    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductForm form){

        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(productService.update(id, form));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){

        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }


}

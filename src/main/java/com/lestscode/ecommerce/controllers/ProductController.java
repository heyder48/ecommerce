package com.lestscode.ecommerce.controllers;

import com.lestscode.ecommerce.models.dto.CategoriaDto;
import com.lestscode.ecommerce.models.dto.ProductDto;
import com.lestscode.ecommerce.models.forms.CategoriaForm;
import com.lestscode.ecommerce.models.forms.ProductForm;
import com.lestscode.ecommerce.models.product.Categoria;
import com.lestscode.ecommerce.models.product.Product;
import com.lestscode.ecommerce.repositories.CategoriaRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

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

    //Categoirias
    @GetMapping("/categories")
    public ResponseEntity<List<CategoriaDto>> listAllCategories(){

        return ResponseEntity.ok(productService.listAllCategories());

    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoriaDto> getCategoryById(@PathVariable Long id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if(categoria.isPresent()){
            return ResponseEntity.ok(productService.getCategoryById(id));
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/categories")
    @Transactional
    public ResponseEntity<CategoriaDto> createCategory(@RequestBody CategoriaForm form){

            CategoriaDto categoriaDto = productService.createCategory(form);
            URI uri = URI.create("/products/categories/" + categoriaDto.getId());
            return ResponseEntity.created(uri).body(categoriaDto);
    }

    @PutMapping("/categories/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> updateCategory(@PathVariable Long id, @RequestBody CategoriaForm form){

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return ResponseEntity.ok(productService.updateCategory(id, form));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/categories/{id}")
    @Transactional
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){

        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            productService.deleteCategory(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }



}

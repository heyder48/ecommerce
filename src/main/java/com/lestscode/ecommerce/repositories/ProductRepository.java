package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.product.Categoria;
import com.lestscode.ecommerce.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {



}

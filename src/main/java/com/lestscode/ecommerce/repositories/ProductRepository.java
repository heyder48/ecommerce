package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}

package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.product.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria,Long> {

}

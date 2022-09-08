package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    void removeById(Long id);

}

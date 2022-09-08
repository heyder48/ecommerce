package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    void deleteByCustomer_Id(Long customerId);


}

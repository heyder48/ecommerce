package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {


    List<Order> findAllByCustomerId(Long id);




}

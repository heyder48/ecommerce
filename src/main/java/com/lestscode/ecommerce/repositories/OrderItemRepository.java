package com.lestscode.ecommerce.repositories;

import com.lestscode.ecommerce.models.order.OrderItem;
import com.lestscode.ecommerce.models.order.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderProductPK> {

    List<OrderItem> findAllByPkOrderId(Long id);

}

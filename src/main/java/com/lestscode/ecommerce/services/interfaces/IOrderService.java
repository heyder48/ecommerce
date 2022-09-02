package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.OrderDto;

import java.util.List;

public interface IOrderService {

    List<OrderDto> listAll();
}

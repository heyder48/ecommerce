package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.OrderDto;
import com.lestscode.ecommerce.models.forms.OrderForm;

import java.util.List;

public interface IOrderService {

    List<OrderDto> listAll();

    OrderDto create(OrderForm form);
}

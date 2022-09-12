package com.lestscode.ecommerce.services.interfaces;

import com.lestscode.ecommerce.models.dto.OrderDto;
import com.lestscode.ecommerce.models.forms.OrderForm;
import com.lestscode.ecommerce.models.forms.UpdateOrderForm;

import java.util.List;

public interface IOrderService {

    List<OrderDto> listAll();

    OrderDto create(OrderForm form);

    OrderDto getById(Long id);

    OrderDto updateStatus(Long id, UpdateOrderForm orderForm);

    void delete(Long id);
}

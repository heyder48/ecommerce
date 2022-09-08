package com.lestscode.ecommerce.controllers;

import com.lestscode.ecommerce.models.dto.OrderDto;
import com.lestscode.ecommerce.models.forms.OrderForm;
import com.lestscode.ecommerce.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderControler {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> listAll(){

        return ResponseEntity.ok(orderService.listAll());
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderForm form){

        OrderDto orderDto = orderService.create(form);
        URI uri = URI.create("/orders/" + orderDto.getId());
        return ResponseEntity.created(uri).body(orderDto);
    }

}

package com.lestscode.ecommerce.controllers;

import com.lestscode.ecommerce.models.dto.OrderDto;
import com.lestscode.ecommerce.models.forms.OrderForm;
import com.lestscode.ecommerce.models.forms.UpdateOrderForm;
import com.lestscode.ecommerce.models.order.Order;
import com.lestscode.ecommerce.repositories.OrderRepository;
import com.lestscode.ecommerce.services.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderControler {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<OrderDto>> listAll(){

        return ResponseEntity.ok(orderService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id){

        Optional<Order> order =orderRepository.findById(id);
        if(order.isPresent()){
            return ResponseEntity.ok(orderService.getById(id));
        }


        return ResponseEntity.notFound().build();
    }

    @PutMapping("/updatestatus/{id}")
    public ResponseEntity<OrderDto> updateStatus(@PathVariable Long id, @RequestBody UpdateOrderForm orderForm) {

        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            return ResponseEntity.ok(orderService.updateStatus(id, orderForm));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderForm form){

        OrderDto orderDto = orderService.create(form);
        URI uri = URI.create("/orders/" + orderDto.getId());
        return ResponseEntity.created(uri).body(orderDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            orderService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

}

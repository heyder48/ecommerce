package com.lestscode.ecommerce.controllers;


import com.lestscode.ecommerce.models.customer.Customer;
import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.models.forms.AtualizarCustomerForm;
import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomeService customeService;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping
    public ResponseEntity<List<CustomerDto>> listAll(){

        return ResponseEntity.ok(customeService.listAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return ResponseEntity.ok(customeService.getById(id));
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @Transactional
    public ResponseEntity<CustomerDto> create(@Valid CustomerForm form){

        return ResponseEntity.ok(customeService.create(form));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, AtualizarCustomerForm form){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customeService.update(id, form));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customeService.delete(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}

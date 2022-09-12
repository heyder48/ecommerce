package com.lestscode.ecommerce.controllers;


import com.lestscode.ecommerce.models.customer.Customer;
import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.models.forms.AtualizarCustomerForm;
import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.models.forms.UpdatePasswordForm;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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


    @Description("List all customers")
    @Operation(summary = "List all customers")

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listAll(){

        return ResponseEntity.ok(customeService.listAll());

    }

    @Description("Get customer by id")
    @Operation(summary = "Get customer by id")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return ResponseEntity.ok(customeService.getById(id));
        }
        return ResponseEntity.notFound().build();

    }

    @Description("Create a new customer")
    @Operation(summary = "Create a new customer")
    @PostMapping
    @Transactional
    public ResponseEntity<CustomerDto> create(@Valid @RequestBody CustomerForm form){

        return ResponseEntity.ok(customeService.create(form));

    }

    @Description("Update customer")
    @Operation(summary = "Update customer")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CustomerDto> update(@PathVariable Long id, @RequestBody AtualizarCustomerForm form){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customeService.update(id, form));
        }

        return ResponseEntity.notFound().build();

    }

    @Description("Update customer password")
    @Operation(summary = "Update customer password")
    @PutMapping("/{id}/updatepassword")
    @Transactional
    public ResponseEntity<String> updatePassword(@PathVariable Long id,@Valid @RequestBody UpdatePasswordForm form){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {

            if (customeService.updatePassword(id, form)) {
                return ResponseEntity.ok("Senha atualizada com sucesso");
            }
            return ResponseEntity.badRequest().body("Senha atual não confere");
        }

        return ResponseEntity.notFound().build();

    }

    @Description("Delete customer")
    @Operation(summary = "Delete customer")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            System.out.println("entrou");
            customeService.delete(id);
            customerRepository.delete(customer.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }
}

package com.lestscode.ecommerce.controllers;


import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomeService customeService;


    @GetMapping
    public ResponseEntity<List<CustomerDto>> listAll(){

        return ResponseEntity.ok(customeService.listAll());

    }
}

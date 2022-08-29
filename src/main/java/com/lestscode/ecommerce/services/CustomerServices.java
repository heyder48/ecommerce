package com.lestscode.ecommerce.services;

import com.lestscode.ecommerce.models.dto.CustomerDto;
import com.lestscode.ecommerce.repositories.CustomerRepository;
import com.lestscode.ecommerce.services.interfaces.ICustomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServices implements ICustomeService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> listAll() {

        return customerRepository.findAll()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());


    }
}


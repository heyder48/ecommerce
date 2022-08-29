package com.lestscode.ecommerce.models.dto;

import com.lestscode.ecommerce.models.customer.Customer;

public class CustomerDto {

    private String name;
    private String cpf;
    private String telephone;
    private String email;
    private String address;

    public CustomerDto(Customer customer){
        this.name = customer.getName();
        this.cpf = customer.getCpf();
        this.telephone = customer.getPhone();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
    }
}

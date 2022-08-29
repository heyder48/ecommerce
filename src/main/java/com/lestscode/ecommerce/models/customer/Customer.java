package com.lestscode.ecommerce.models.customer;

import com.lestscode.ecommerce.exceptions.CpfInvalidoException;
import com.lestscode.ecommerce.exceptions.PhoneException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CPF cpf;
    private Phone phone;
    private Email email;
    private CustomerAddress address;

    public Customer(){}

    public Customer(String name,String cpf, String ddd, String phoneNumber, String emailAddress, String cep,String logadouro,String numero,String bairro, String cidade, String uf) throws CpfInvalidoException, PhoneException {

        this.name = name;
        this.cpf = new CPF(cpf);
        this.phone = new Phone(ddd,phoneNumber);
        this.address = new CustomerAddress(logadouro,numero,bairro,cidade,uf,cep);
        this.email = new Email(emailAddress);

    }

    public String getName() {
        return name;
    }

    public String getCpf() {

        return cpf.getCpf();
    }

    public String getPhone() {

        return phone.getTelefone();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public String getAddress() {

        return address.getEndereco();
    }
}
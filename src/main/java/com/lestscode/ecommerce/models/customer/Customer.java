package com.lestscode.ecommerce.models.customer;


import com.lestscode.ecommerce.models.forms.CustomerForm;
import com.lestscode.ecommerce.utils.Utils;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;

    private String address;

    private String password;

    public Customer(){}

    public Customer(String name,String cpf, String ddd, String phoneNumber, String emailAddress, String cep,String logadouro,String numero,String bairro, String cidade, String uf)  {

        this.name = name;
        this.cpf = cpf;
        this.phone = ddd+phoneNumber;
        this.address = logadouro+","+numero+","+bairro+","+cidade+","+uf+","+cep;
        this.email = emailAddress;

    }

    public Customer(CustomerForm form){
        this.name = form.getName();
        this.cpf = form.getCpf();
        this.phone = form.getDdd()+form.getPhoneNumber();
        this.address = form.getLogadouro()+","+form.getNumero()+","+form.getBairro()+","+form.getCidade()+","+form.getUf()+","+form.getCep();
        this.email = form.getEmailAddress();
        this.password = Utils.criptografarSenha(form.getPassword());
    }

    public String getName() {
        return name;
    }

    public String getCpf() {

        return cpf;
    }

    public String getPhone() {

        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {

        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
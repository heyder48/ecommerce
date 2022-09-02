package com.lestscode.ecommerce.models.forms;

import com.lestscode.ecommerce.validation.CpfConstraint;
import com.lestscode.ecommerce.validation.DDD;
import com.lestscode.ecommerce.validation.Phone;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

public class CustomerForm {

    @NotNull
    @Getter @Setter
    private String name;
    @CpfConstraint
    @Getter @Setter
    private String cpf;
    @DDD
    @Getter @Setter
    private String ddd;
    @Phone
    @Getter @Setter
    private String phoneNumber;
    @Email
    @Getter @Setter
    private String emailAddress;
    @NotNull
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String cep;
    @Getter @Setter
    private String logadouro;
    @Getter @Setter
    private String numero;
    @Getter @Setter
    private String bairro;
    @Getter @Setter
    private String cidade;
    @Getter @Setter
    private String uf;


}

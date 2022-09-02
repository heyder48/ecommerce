package com.lestscode.ecommerce.models.forms;

import lombok.Getter;
import lombok.Setter;

public class AtualizarCustomerForm {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String cpf;
    @Getter @Setter
    private String ddd;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    private String emailAddress;
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

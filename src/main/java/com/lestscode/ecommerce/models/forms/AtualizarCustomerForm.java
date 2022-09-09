package com.lestscode.ecommerce.models.forms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AtualizarCustomerForm {

    private String name;

    private String cpf;

    private String ddd;

    private String phoneNumber;

    private String emailAddress;


    private String cep;

    private String logadouro;

    private String numero;

    private String bairro;

    private String cidade;

    private String uf;
}

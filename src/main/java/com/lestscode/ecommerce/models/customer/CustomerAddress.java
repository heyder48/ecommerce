package com.lestscode.ecommerce.models.customer;

public class CustomerAddress {

    private  String logradouro;
    private  String numero;
    private  String bairro;
    private  String cidade;
    private  String estado;
    private  String cep;


    public CustomerAddress(String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getEndereco() {

        return logradouro + ", " + numero + ", " + bairro + ", " + cidade + ", " + estado + ", " + cep;
    }
}

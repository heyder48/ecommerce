package com.lestscode.ecommerce.models.customer;

import com.lestscode.ecommerce.exceptions.PhoneException;
import com.lestscode.ecommerce.models.Validacao;

public class Phone implements Validacao {

    public String ddd;
    public String numero;

    public Phone(String ddd, String numero) throws PhoneException {
        if(validar(ddd)){
            this.ddd = ddd;

        }else{

            throw new PhoneException("DDD em formato invalido");

        }

        if (validar(numero)){
            this.numero = numero;
        }else {

            throw new PhoneException("Número de Telefone em formato invalido");
        }


    }

    public String getTelefone(){
        return "("+this.ddd+")"+this.numero;
    }

    @Override
    public boolean validar(String param) {

        return param.length() == 2? param.matches("^[0-9]{2}"):param.matches("^([0-9]{8}|[0-9]{9})");
    }
}

package com.lestscode.ecommerce.models.customer;

import com.lestscode.ecommerce.exceptions.CpfInvalidoException;
import com.lestscode.ecommerce.models.Validacao;

public class CPF implements Validacao {

    private String cpfNumber;

    public CPF(String number) throws CpfInvalidoException {
        if(validar(number)){
            cpfNumber = number;
        }else {

            throw new CpfInvalidoException("CPF invalido");
        }

    }


    @Override
    public boolean validar(String param) {
        return param.length() != 11;
    }

    public String getCpf() {
        return cpfNumber;
    }
}

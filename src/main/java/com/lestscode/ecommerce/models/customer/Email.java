package com.lestscode.ecommerce.models.customer;

import com.lestscode.ecommerce.models.Validacao;

import java.util.regex.Pattern;

public class Email implements Validacao {

    private String email;

    public Email(String email) {

        if (validar(email.trim())) {
            this.email = email.trim();
        } else {
            throw new IllegalArgumentException("Email inválido");
        }

    }

    public String getEmail() {
        return email;
    }


    @Override
    public boolean validar(String param) {

        if(param.isEmpty() || param == null){
            return false;
        }

        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

        return EMAIL_REGEX.matcher(param).matches();
    }
}

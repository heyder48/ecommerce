package com.lestscode.ecommerce.utils;

import java.security.MessageDigest;

public class Utils {

    //criptografar senha
    public static String criptografarSenha(String senha) {

        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(senha.getBytes());
            return bytesToHex(algorithm.digest());
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    private static String bytesToHex(byte[] hash){
        StringBuffer sb = new StringBuffer();
        for(byte b : hash){
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}

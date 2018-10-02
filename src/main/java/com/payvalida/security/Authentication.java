package com.payvalida.security;

import com.payvalida.encrypt.Encryptor;

public class Authentication {
    //properites
    private static final String FIXED_HASH = "";

    public String generateCheckSum(String... fields){
        String fieldsConcated = "";
        for (String f: fields) {
            fieldsConcated += f;
        }
        fieldsConcated += FIXED_HASH;
        return Encryptor.encryptSHA512(fieldsConcated);
    }

}

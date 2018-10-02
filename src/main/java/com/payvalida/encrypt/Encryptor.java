package com.payvalida.encrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public static String encryptSHA512(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            return String.format("%040x", new BigInteger(1, digest.digest()));

        }catch (NoSuchAlgorithmException e) {
            e.fillInStackTrace();
        }catch (UnsupportedEncodingException u) {
            u.fillInStackTrace();
        }
        return null;
    }

}

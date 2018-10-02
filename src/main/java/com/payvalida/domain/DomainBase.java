package com.payvalida.domain;

import com.payvalida.security.Authentication;

public class DomainBase {

    //properties
    public static final String merchant = "sofasa";
    private String checksum;

    public String getMerchant() {
        return merchant;
    }

    public String getChecksum() {
        return checksum;
    }
}

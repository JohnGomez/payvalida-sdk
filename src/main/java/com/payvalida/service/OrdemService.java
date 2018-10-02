package com.payvalida.service;

import com.payvalida.domain.DomainBase;
import com.payvalida.domain.OrdemCompraRequest;
import com.payvalida.security.Authentication;

import java.util.HashMap;
import java.util.Map;

public class OrdemService extends AbstractService<OrdemCompraRequest> {

   private static final String PATH = "porders";

    public String findAll() {
        Map<String, String> parameters = new HashMap<>();
        Authentication authentication = new Authentication();

        parameters.put("merchant", DomainBase.merchant);
        parameters.put("checksum", authentication.generateCheckSum(DomainBase.merchant));

        super.get(PATH,parameters);
        return null;
    }

    public String create(OrdemCompraRequest ordemCompraRequest) {
        super.post(PATH, ordemCompraRequest);
        return null;
    }

    public static void main(String[] args) {
        OrdemService ordemService = new OrdemService();
        ordemService.findAll();
    }
}

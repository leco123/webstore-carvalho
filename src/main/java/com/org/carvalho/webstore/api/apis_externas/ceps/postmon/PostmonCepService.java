package com.org.carvalho.webstore.api.apis_externas.ceps.postmon;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.AbstractCepService;

import javax.enterprise.context.Dependent;

@Dependent
public class PostmonCepService extends AbstractCepService {

    public PostmonCepService() {
        super("https://api.postmon.com.br");
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("/v1/cep/%s", cep);
    }
}

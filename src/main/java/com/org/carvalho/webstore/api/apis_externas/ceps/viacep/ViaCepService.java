package com.org.carvalho.webstore.api.apis_externas.ceps.viacep;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.AbstractCepService;

import javax.enterprise.context.Dependent;

@Dependent
public final class ViaCepService extends AbstractCepService {

    public ViaCepService() {
        super("http://viacep.com.br/");
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("ws/%s/json", cep);
    }
}

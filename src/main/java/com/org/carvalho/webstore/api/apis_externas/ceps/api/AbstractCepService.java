package com.org.carvalho.webstore.api.apis_externas.ceps.api;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.dtos.EnderecoCEPAPIDTO;
import com.org.carvalho.webstore.api.apis_externas.ceps.api.interfaces.ConsumeApiCEP;

import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class AbstractCepService implements ConsumeApiCEP {

    private WebTarget target;
    private String dominio;
    private String dominioPrincipal;

    public AbstractCepService() {
        addDominio();
        fazerRequisicaoServidor();
    }

    @Override
    public EnderecoCEPAPIDTO bucarEndereco(String cep) {
        return target.path(buildPath(cep)).request().get(EnderecoCEPAPIDTO.class);
    }

    protected abstract String buildPath(String cep);

    private void addDominio(){
        this.dominioPrincipal = "http://viacep.com.br/";
    }

    /**
     * Verifica se existe a / no final do caminho, caso não exista é adicionado uma barra
     * porque será necessário juntar vários caminhos
     * @param path
     * @return String
     */
    protected final String insertTrailingSlash(String path){
        return path.endsWith("/") ? path : path+"/";
    }

    protected String getFullPath(String cep) {
        return this.dominio + buildPath(cep);
    }

    private void fazerRequisicaoServidor() {
        this.dominio = insertTrailingSlash(this.dominioPrincipal);
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }
}

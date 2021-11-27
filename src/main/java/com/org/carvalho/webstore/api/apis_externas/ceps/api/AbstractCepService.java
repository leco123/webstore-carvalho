package com.org.carvalho.webstore.api.apis_externas.ceps.api;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.dtos.EnderecoCEPAPIDTO;
import com.org.carvalho.webstore.api.apis_externas.ceps.api.interfaces.ConsumeApiCEP;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.logging.Logger;

public abstract class AbstractCepService implements ConsumeApiCEP {

    private static final Logger LOG = Logger.getLogger(AbstractCepService.class.getName());

    private WebTarget target;
    private String dominio;
    private final String dominioPrincipal;

    public AbstractCepService(String dominioPrincipal) {
        this.dominioPrincipal = dominioPrincipal;
        fazerRequisicaoServidor();
    }

    @Override
    public EnderecoCEPAPIDTO bucarEndereco(String cep) {
        LOG.info(String.format("Buscando endereço para o CEP: %s usando serviço (API) %s", cep, this.dominio));
        return target.path(buildPath(cep)).request().get(EnderecoCEPAPIDTO.class);
    }

    protected abstract String buildPath(String cep);

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
        LOG.info(String.format("Carregando API %s", this.dominio));
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }
}

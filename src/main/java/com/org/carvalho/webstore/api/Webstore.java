package com.org.carvalho.webstore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.org.carvalho.webstore.api.share.ConfiguracaoSistema;
import io.swagger.annotations.ApiModel;


@ApiModel(description = "Classe Principal")
@Path("/api/v1/")
public class Webstore {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {

        return "Seja bem vindo ao  \""+ConfiguracaoSistema.configNomeSistema
                + "\" Versão: "+ConfiguracaoSistema.confgiVersao;
    }

}

package com.org.carvalho.webstore.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.org.carvalho.webstore.api.share.ConfiguracaoSistema;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;


@Api("Classe Principal")
@Tag(name = "Informações do Sistema", description = "Informações de versão do sistema, quem desenvolveu, outros...")
@Path("/api/v1/")
public class Webstore {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {

        return "Seja bem vindo ao projeto \""+ConfiguracaoSistema.configNomeSistema
                + "\" Versão: "+ConfiguracaoSistema.confgiVersao;
    }

}

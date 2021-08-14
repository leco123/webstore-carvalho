package com.org.carvalho.webstore.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;
import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.share.ConfiguracaoSistema;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;


@Api("Classe Principal")
@Path("/api/v1")
public class Webstore {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {

        return "Seja bem vindo ao projeto \""+ConfiguracaoSistema.configNomeSistema
                + "\" Versão: "+ConfiguracaoSistema.confgiVersao;
    }
	
	@GET
	@Path("/salvar-registros")
    public void salvarRegistros() {

    }
	

}

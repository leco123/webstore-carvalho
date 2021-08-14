package com.org.carvalho.webstore.api.features.unidade;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.org.carvalho.webstore.api.share.endereco.bairro.Bairro;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;
import com.org.carvalho.webstore.api.share.endereco.tipo.TipoEndereco;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

@Path("/api/v1/unidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UnidadeService {
	
	@Inject
	UnidadeResource unidadeResource;


}

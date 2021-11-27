package com.org.carvalho.webstore.api.apis_externas.ceps.postmon;

import com.org.carvalho.webstore.api.apis_externas.ceps.api.dtos.EnderecoCEPAPIDTO;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/cep")
public class PostmonCepResource {

    @Inject
    PostmonCepService postmonCepService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("buscar/{cep}")
    public EnderecoCEPAPIDTO getEndereco(@PathParam("cep") String cep){
        return postmonCepService.bucarEndereco(cep);
    }
}

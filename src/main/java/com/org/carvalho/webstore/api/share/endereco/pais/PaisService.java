package com.org.carvalho.webstore.api.share.endereco.pais;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/pais")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaisService {

    @Inject
    PaisResource paisResource;

    @POST
    public void salvar(Pais pais) throws Exception {
        paisResource.adicionar(pais);
    }

}

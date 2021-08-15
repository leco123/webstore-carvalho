package com.org.carvalho.webstore.api.share.endereco.pais;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("País")
@Path("/api/v1/pais")
public class PaisService implements CrudService<Pais, Long> {

    @Inject
    PaisResource paisResource;

    @ApiOperation("Gravar País")
    @Override
    public Pais salvar(Pais entidade) {
        return paisResource.adicionar(entidade);
    }

    @ApiOperation("Atualizar País")
    @Override
    public Pais atualizar(Pais entidade) {
        return paisResource.atualizar(entidade);
    }

    @ApiOperation("Remover País")
    @Override
    public Pais removerPorId(Long id) {
        return paisResource.remover(id);
    }

    @ApiOperation("Buscar País")
    @Override
    public Pais encontrePorId(Long id) {
        return paisResource.obterPorId(id);
    }

    @GET
    @Path("ALL")
    @ApiOperation("Retornar Todos os Países")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pais> buscarTodosPaises() {
        return paisResource.obterTudo();
    }

}

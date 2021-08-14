package com.org.carvalho.webstore.api.share.util.moeda;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Moedas")
@Path("/api/v1/moeda")
public class MoedaService implements CrudService<Moeda, Long> {

    @Inject
    MoedaResource moedaResource;

    @ApiOperation("Gravar Moeda")
    @Override
    public Moeda salvar(Moeda entidade) {
        return moedaResource.adicionar(entidade);
    }

    @ApiOperation("Atualizar Moeda")
    @Override
    public Moeda atualizar(Moeda entidade) {
        return moedaResource.atualizar(entidade);
    }

    @ApiOperation("Remover Moeda")
    @Override
    public Moeda removerPorId(Long id) {
        return moedaResource.remover(id);
    }

    @ApiOperation("Retornar Moeda por ID")
    @Override
    public Moeda encontrePorId(Long id) {
        return moedaResource.obterPorId(id);
    }

    @GET
    @Path("ALL")
    @ApiOperation("Retornar Todas as Moedas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moeda> buscarTodasMoedas() {
        return moedaResource.obterTudo();
    }

}

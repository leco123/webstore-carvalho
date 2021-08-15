package com.org.carvalho.webstore.api.share.util.crud;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

/*
 * A base para um DAO genérico são suas operações CRUD.
 * A seguinte interface define os métodos auxíliar na implementação
 * de métodos crud:
 */
public interface CrudService<T, PK extends Serializable> {

    /**
     * Gravar Entidade
     * @param entidade Entidade
     * @return Object T
     */
    @ApiOperation("Gravar Entidade")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    T salvar(@NotNull T entidade);

    /**
     * Atualizar Entidade
     * @param entidade Entidade
     * @return Object T
     */
    @ApiOperation("Atualizar Entidade")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    T atualizar(@NotNull T entidade);

    /**
     * Remover Entidade
     * @param id
     * @return Object T
     */
    @ApiOperation("Remover Entidade")
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    T removerPorId(@PathParam("id") @NotNull @ApiParam("Código") PK id);

    /**
     * Buscar por ID
     * @param id
     * @return Object T
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    T encontrePorId(@PathParam("id") @NotNull @ApiParam("Código") PK id);
}

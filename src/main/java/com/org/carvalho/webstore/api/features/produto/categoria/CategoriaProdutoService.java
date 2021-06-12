package com.org.carvalho.webstore.api.features.produto.categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api("Categoria do Produto")
@Path("/api/v1/produto/categoria")
public class CategoriaProdutoService {

    @Inject
    CategoriaProdutoResource categoria;

    /**
     * Filtra todas as categorias
     * @throws Exception Erro
     * @author Alex de Carvalho
     */
    @ApiOperation("Filtra todas as categorias")
    @GET
    @Path("/ALL")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String listarTodosOsProduto() throws Exception {
        return "";
    }

    @ApiOperation("Filtra categoria por código")
    @ApiModelProperty(name = "codigo")
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String getCategoriaId() throws Exception {
        return "";
    }

}

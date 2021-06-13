package com.org.carvalho.webstore.api.features.produto.categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Categoria do Produto")
@Path("/api/v1/produto/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaProdutoService {

    @Inject
    CategoriaProdutoResource categoria;

    /**
     * Filtra todas as categorias
     * @throws Exception Erro
     * @author Alex de Carvalho
     */
    @ApiOperation("Filtrar todas as categorias")
    @GET
    @Path("ALL")
    public List<CategoriaProduto> listarTodosOsProduto(){
    	try {
    		return categoria.obterCategorias();
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterCategorias() "+e);
		}
    	return null;
    }

    @ApiOperation("Filtrar categoria por código")
    @ApiModelProperty(name = "codigo")
    @GET
    @Path("{codigo}")
    public Response getCategoriaId(@PathParam("codigo") long codigoCategoria) {
    	try {
    		CategoriaProduto cat =	categoria.obterObjetoPorID(codigoCategoria);
    		return Response.ok(cat).build();
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterObjetoPorID(codigoCategoria) "+e);
		}
		return null;
    }

}

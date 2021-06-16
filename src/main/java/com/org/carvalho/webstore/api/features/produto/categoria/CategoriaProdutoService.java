package com.org.carvalho.webstore.api.features.produto.categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.hibernate.annotations.Parameter;

@Tag(name = "Categoria do Produto", description = "Categorias dos Produtos")
@Path("/api/v1/produto/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaProdutoService {

    @Inject
    CategoriaProdutoResource categoriaResource;

    /**
     * Filtra todas as categorias
     * @author Alex de Carvalho
     */
    @ApiOperation("Filtrar todas as categorias")
    @GET
    @Path("ALL")
   
    public List<CategoriaProduto> listarTodosOsProduto(){
    	try {
    		return categoriaResource.obterCategorias();
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
    public CategoriaProduto getCategoriaId(@PathParam("codigo") long codigoCategoria) {
    	try {
    		return categoriaResource.obterObjetoPorID(codigoCategoria); 
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterObjetoPorID(codigoCategoria) "+e);
		}
		return null;
    }
    
    
    @ApiOperation("Salvar Categoria do produto")
    @POST
    public void adicionarCategoria() {

    	try {
			CategoriaProduto categoria = new CategoriaProduto();
			CategoriaProduto categoria2 = new CategoriaProduto();

			categoria.setNome("Nome da Categoria 1");
			categoria.setAtivo(true);
			categoria.setDatahoracadastro(LocalDateTime.now());

			categoria2.setNome("Nome da Categoria 2 ");
			categoria2.setAtivo(true);
			categoria2.setDatahoracadastro(LocalDateTime.now());

			categoriaResource.addCategoriaProduto(categoria);
			categoriaResource.addCategoriaProduto(categoria2);

		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método addCategoriaProduto(categoria) "+e);
		}
    }

}

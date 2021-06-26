package com.org.carvalho.webstore.api.features.produto.categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.features.unidade.UnidadeResource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Path("/api/v1/produto/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class CategoriaProdutoService {

	private static final Logger LOGGER = Logger.getLogger(String.valueOf(CategoriaProdutoService.class));

    @Inject
    CategoriaProdutoResource categoriaResource;

    @Inject
	UnidadeResource unidadeResource;


    /**
     * Filtra todas as categorias
     * @author Alex de Carvalho
     */
    @GET
    @Path("ALL")
    public List<CategoriaProduto> listarTodosOsProduto(){
    	try {
    		return categoriaResource.obterCategorias();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }



    @GET
    @Path("{codigo}")
    public Response getCategoriaId(@PathParam("codigo") long codigoCategoria) {
		try {
			CategoriaProduto  categoria = categoriaResource.encontrePorId(codigoCategoria);
			return Response
					.status(200)
					.entity(categoria)
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }

    @POST
    public Response adicionarCategoria() {
    	try {
    		
			CategoriaProduto categoria = new CategoriaProduto();
			CategoriaProduto categoria2 = new CategoriaProduto();

			Unidade unidade = unidadeResource.encontrePorId(1L);

			categoria.setNome("Categoria de Teste 1 (UM)");
			categoria.setAtivo(true);
			categoria.setDatahoracadastro(LocalDateTime.now());
			categoria.setUnidade(unidade);

			categoria2.setNome("Categoria de Teste 2 (DOIS)");
			categoria2.setAtivo(true);
			categoria2.setDatahoracadastro(LocalDateTime.now());
			categoria2.setUnidade(unidade);
			categoriaResource.addCategoriaProduto(categoria);
			categoriaResource.addCategoriaProduto(categoria2);

			return Response
					.status(200)
					.entity("Registro(s) inserido:"
							+categoria.toString())
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }

	@DELETE
	@Path("/{codigo}")
	public Response removerCategoria(@PathParam("codigo") Long codigoCategoria) {
    	try {
    		CategoriaProduto categoriaProduto = categoriaResource.removerCategoria(codigoCategoria);

			return Response
					.status(200)
					.entity("Registro removido com sucesso.")
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}

	}

	@PUT
	public Response updateCategoria(CategoriaProduto categoriaProduto) {
		try {
			categoriaResource.atualizarCategoria(categoriaProduto);
			return Response
					.status(200)
					.entity("Registro atualizado com sucesso. \n "+ categoriaProduto)
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
	}

}

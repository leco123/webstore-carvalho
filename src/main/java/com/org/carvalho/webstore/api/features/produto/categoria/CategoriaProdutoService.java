package com.org.carvalho.webstore.api.features.produto.categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
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
    		return categoriaResource.obterTudo();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }

    @GET
    @Path("{codigo}")
    public CategoriaProduto getCategoriaId(@PathParam("codigo") Long codigoCategoria) {
		try {
			return this.categoriaResource.obterPorId(codigoCategoria);
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }

	@GET
    @Path("/todas")
    public List<CategoriaProdutoDTO> getListCategoriasDTO() {
		try {
			return categoriaResource.obterCategoriasDTO();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
    }

	@GET
	@Path("/nome/{nome}")
	public Response getCategoriaNome(@PathParam("nome") String nome) {
		try {
			List<CategoriaProduto>  categorias = categoriaResource.obterPorNome(nome);
			GenericEntity<List<CategoriaProduto>> entidades = new GenericEntity<List<CategoriaProduto>>(categorias){};
			return Response
					.ok(entidades)
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

			Unidade unidade = unidadeResource.obterPorId(1L);

			categoria.setNome("Categoria de Teste 1 (UM)");
			categoria.setAtivo(true);
			categoria.setDatahoracadastro(LocalDateTime.now());
			categoria.setUnidade(unidade);

			categoria2.setNome("Categoria de Teste 2 (DOIS)");
			categoria2.setAtivo(true);
			categoria2.setDatahoracadastro(LocalDateTime.now());
			categoria2.setUnidade(unidade);
			categoriaResource.adicionar(categoria);
			categoriaResource.adicionar(categoria2);

			return Response
					.status(200)
					.entity("Registro(s) inserido com sucesso: "
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
    		categoriaResource.remover(codigoCategoria);
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
			categoriaResource.atualizar(categoriaProduto);
			return Response
					.status(200)
					.entity("Registro atualizado com sucesso. \n "+ categoriaProduto)
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
	}

	@GET
	@Path("/unidade/categoria/{categoria}")
	public Response unidadeDaCategoria(@PathParam("categoria") Long categoria) {

		if (categoria == null) {
			throw new NullPointerException("Código da categoria não pode ser null");
		}

		try {
			CategoriaProduto categoriaProduto = categoriaResource.obterPorId(categoria);
			if (categoriaProduto == null) {
				throw new NullPointerException("Não foi possível encontrar a categoria de código "+categoria);
			}

			Unidade unidade = categoriaProduto.getUnidade();
			if (unidade == null) {
				throw new NullPointerException("Não foi possível encontrar a unidade da categoria do produto");
			}

			GenericEntity<Unidade> entidade = new GenericEntity<Unidade>(unidade){};
			return Response
					.ok(entidade)
					.entity(entidade)
					.build();
		} catch (Exception e) {
			LOGGER.severe(e.getMessage());
			throw  new WebApplicationException(500);
		}
	}

}

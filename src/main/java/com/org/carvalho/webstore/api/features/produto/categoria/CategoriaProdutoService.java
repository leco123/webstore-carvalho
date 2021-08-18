package com.org.carvalho.webstore.api.features.produto.categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.features.unidade.UnidadeResource;
import com.org.carvalho.webstore.api.share.endereco.bairro.Bairro;
import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
@Api("Categoria")
@Path("/api/v1/produto/categoria")
public class CategoriaProdutoService implements CrudService<CategoriaProduto, Long> {

	private static final Logger LOGGER = Logger.getLogger(String.valueOf(CategoriaProdutoService.class));

    @Inject
    CategoriaProdutoResource categoriaResource;

    @Inject
	UnidadeResource unidadeResource;

	/**
	 * Gravar CategoriaProduto
	 * @param entidade CategoriaProduto
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto salvar(CategoriaProduto entidade) {
		return categoriaResource.adicionar(entidade);
	}

	/**
	 * Atualizar CategoriaProduto
	 * @param entidade CategoriaProduto
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto atualizar(CategoriaProduto entidade) {
		return categoriaResource.atualizar(entidade);
	}

	/**
	 * Remover CategoriaProduto
	 * @param id
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto removerPorId(Long id) {
		return categoriaResource.remover(id);
	}

	/**
	 * Buscar por ID
	 * @param id
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto encontrePorId(Long id) {
		return categoriaResource.obterPorId(id);
	}


	/**
	 * Listar todos os Bairros
	 * @return List<CategoriaProduto>
	 */
	@GET
	@Path("ALL")
	@ApiOperation("Retornar todas as Categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaProduto> buscarTodasAsCategorias() {
		return categoriaResource.obterTudo();
	}

	@GET
    @Path("/todas")
	@Produces(MediaType.APPLICATION_JSON)
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
	@Produces(MediaType.APPLICATION_JSON)
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

	@GET
	@Path("/unidade/categoria/{categoria}")
	@Produces(MediaType.APPLICATION_JSON)
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

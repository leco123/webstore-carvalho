package com.org.carvalho.webstore.api.features.produto.categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.org.carvalho.webstore.api.features.produto.categoria.dto.CategoriaPorUnidadeEProdutoDTO;
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
	 * Listar todas as Categorias de Produtos
	 * @return List<CategoriaProduto>
	 */
	@GET
	@Path("ALL")
	@ApiOperation("Retornar todas as Categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaProduto> buscarTodasAsCategorias() throws Exception {
		return categoriaResource.obterTudo();
	}

	@GET
	@Path("unidade")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaPorUnidadeEProdutoDTO> getCategoriaPorUnidade()  {
		return categoriaResource.buscarCategoriaPorUnidadeEProduto();
	}

	/*
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

	}*/

}

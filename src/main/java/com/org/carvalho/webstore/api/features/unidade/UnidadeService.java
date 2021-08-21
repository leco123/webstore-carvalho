package com.org.carvalho.webstore.api.features.unidade;

import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;
import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Unidade/Estabelecimento")
@Path("/api/v1/unidade")
public class UnidadeService implements CrudService<Unidade, Long> {
	
	@Inject
	UnidadeResource unidadeResource;

	/**
	 * Gravar Unidade
	 * @param entidade Unidade
	 * @return Unidade
	 */
	@Override
	public Unidade salvar(Unidade entidade) {
		return unidadeResource.adicionar(entidade);
	}

	/**
	 * Atualizar Unidade
	 * @param entidade Unidade
	 * @return Unidade
	 */
	@Override
	public Unidade atualizar(Unidade entidade) {
		return unidadeResource.atualizar(entidade);
	}

	/**
	 * Remover Unidade
	 * @param id
	 * @return Unidade
	 */
	@Override
	public Unidade removerPorId(Long id) {
		return unidadeResource.remover(id);
	}

	/**
	 * Buscar Unidade  por ID
	 * @param id
	 * @return Unidade
	 */
	@Override
	public Unidade encontrePorId(Long id) {
		return unidadeResource.obterPorId(id);
	}

	/**
	 * Listar todos os Bairros
	 * @return List<CategoriaProduto>
	 */
	@GET
	@Path("ALL")
	@ApiOperation("Retornar todas as Unidades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Unidade> buscarTodasAsCategorias() throws Exception {
		return unidadeResource.obterTudo();
	}
}

package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.features.produto.categoria.dto.CategoriaPorUnidadeEProdutoDTO;
import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.features.unidade.unidadelogada.dto.UnidadeSimples;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@RequestScoped
public  class CategoriaProdutoResource extends CRUD<CategoriaProduto, Long>
		implements CrudBasic<CategoriaProduto> {

	@Inject
	EntityManager em;

	public CategoriaProdutoResource() {
		super(CategoriaProduto.class);
	}


	/**
	 * Adicionar CategoriaProduto
	 * @param categoriaProduto
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto adicionar(CategoriaProduto categoriaProduto) {
		return super.salvar(categoriaProduto);
	}

	/**
	 * Listar todas as Categorias dos Produtos
	 * @return List<CategoriaProduto>
	 */
	@Override
	public List<CategoriaProduto> obterTudo() {
		return super.encontreTodos();
	}

	/**
	 * Obter CategoriaProduto por ID
	 * @param id
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto obterPorId(Long id) {
		return super.encontrePorId(id);
	}

	/**
	 * Remover CategoriaProduto por ID
	 * @param id
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto remover(Long id) {
		return super.deletePorId(id);
	}

	/**
	 * Atualizar CategoriaProduto
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto atualizar(CategoriaProduto categoriaProduto) {
		return super.update(categoriaProduto);
	}

	public List<CategoriaPorUnidadeEProdutoDTO> buscarCategoriaPorUnidadeEProduto () {
		List<CategoriaPorUnidadeEProdutoDTO> result = new ArrayList<>();

		String jpql = "select distinct(categoriaProduto) " +
					  "from CategoriaProduto categoriaProduto "+
				      "join categoriaProduto.unidade unidade ";
		TypedQuery<CategoriaProduto> query = em.createQuery(jpql, CategoriaProduto.class);
		List<CategoriaProduto> categoriaProduto =  query.getResultList();
		if (categoriaProduto == null) {
			throw new NullPointerException("Não existe categoria de produto");
		}

		for (CategoriaProduto categoria : categoriaProduto) {
			List<UnidadeSimples> unidades = new ArrayList<>();
			CategoriaPorUnidadeEProdutoDTO categoriaProdutoDto = new CategoriaPorUnidadeEProdutoDTO();
			categoriaProdutoDto.setId(categoria.getId());
			categoriaProdutoDto.setNome(categoria.getNome());
			for (Unidade unidade: categoria.getUnidade()) {
				UnidadeSimples unidadeSimples = new UnidadeSimples();
				unidadeSimples.setId(unidade.getId());
				unidadeSimples.setNome(unidade.getId() +" - "+unidade.getNome());
				unidadeSimples.setPais(unidade.getEndereco().getPais().getId() +" - "+unidade.getEndereco().getPais().getNome());
				unidadeSimples.setCidade(unidade.getEndereco().getCidade().getId()+" - "+unidade.getEndereco().getCidade().getNome());
				unidades.add(unidadeSimples);
			}

			categoriaProdutoDto.setUnidade(unidades.stream()
					.sorted(Comparator.comparingLong(UnidadeSimples::getId))
					.collect(Collectors.toList()));
			result.add(categoriaProdutoDto);
		}

		return result.stream().sorted(Comparator.comparing(CategoriaPorUnidadeEProdutoDTO::getId)).collect(Collectors.toList());
	}
}

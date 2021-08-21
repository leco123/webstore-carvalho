package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public  class CategoriaProdutoResource extends CRUD<CategoriaProduto, Long>
		implements CrudBasic<CategoriaProduto> {

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
	 * @param categoriaProduto
	 * @return CategoriaProduto
	 */
	@Override
	public CategoriaProduto atualizar(CategoriaProduto categoriaProduto) {
		return super.update(categoriaProduto);
	}
}

package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CategoriaProdutoResource extends CRUD<CategoriaProduto, Long> {

	protected CategoriaProdutoResource() {
		super(CategoriaProduto.class);
	}

	public CategoriaProduto addCategoriaProduto(CategoriaProduto categoria) {
    	return salvarRegistro(categoria);
    }

    public List<CategoriaProduto> obterCategorias() {
		return encontreTodos();
	}

	public CategoriaProduto removerCategoria(Long id) {
		return deletePorId(id);
	}

	public CategoriaProduto atualizarCategoria(CategoriaProduto categoriaProduto) {
		return update(categoriaProduto);
	}
}

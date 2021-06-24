package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.transaction.Transactional;

@RequestScoped
public class CategoriaProdutoResource extends CRUD<CategoriaProduto> {

	public CategoriaProdutoResource() {
		super(CategoriaProduto.class);
	}

	public void addCategoriaProduto(CategoriaProduto categoria) {
    	inserir(categoria);
    }

    public List<CategoriaProduto> obterCategorias() {
		return obterRegistros(100, 0);
	}

	public void removerCategoria(long categoria) throws Exception {
		  remover(categoria);
	}
}

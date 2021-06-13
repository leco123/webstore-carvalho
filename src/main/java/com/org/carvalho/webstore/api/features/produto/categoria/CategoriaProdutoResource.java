package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CategoriaProdutoResource extends CRUD<CategoriaProduto> {

	public CategoriaProdutoResource() {
		super(CategoriaProduto.class);
	}

	public void addCategoriaProduto(CategoriaProduto categoria) throws Exception {
    	this.INSERT(categoria);
    }

    public List<CategoriaProduto> obterCategorias()  throws Exception {
		return obterRegistros(100, 0);
	}
    
}

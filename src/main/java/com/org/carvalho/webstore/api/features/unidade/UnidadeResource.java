package com.org.carvalho.webstore.api.features.unidade;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

@RequestScoped
public class UnidadeResource extends CRUD<Unidade, Long>  implements CrudBasic<Unidade>{

	protected UnidadeResource() {
		super(Unidade.class);
	}


	@Override
	public Unidade adicionar(Unidade entidade) {
		return this.salvar(entidade);
	}

	@Override
	public List<Unidade> obterTudo() {
		return encontreTodos();
	}

	@Override
	public Unidade obterPorId(Long id) {
		return encontrePorId(id);
	}

	@Override
	public Unidade remover(Long id) {
		return deletePorId(id);
	}

	@Override
	public Unidade atualizar(Unidade entidade) {
		return update(entidade);
	}

}

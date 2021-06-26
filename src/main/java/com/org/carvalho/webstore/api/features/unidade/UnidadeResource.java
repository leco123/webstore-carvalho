package com.org.carvalho.webstore.api.features.unidade;

import javax.enterprise.context.RequestScoped;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;

@RequestScoped
public class UnidadeResource extends CRUD<Unidade, Long> {

	public UnidadeResource() {
		super(Unidade.class);
	}

	public Unidade add(Unidade unidade) {
		return salvarRegistro(unidade);
    }

}

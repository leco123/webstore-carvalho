package com.org.carvalho.webstore.api.features.unidade;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;

@RequestScoped
public class UnidadeResource extends CRUD<Unidade> {
	
	public UnidadeResource() {
		super(Unidade.class);
	}
	
	public void add(Unidade unidade) {
    	inserir(unidade);
    }

    public List<Unidade> obter() {
		return obterRegistros(100, 0);
	} 

}

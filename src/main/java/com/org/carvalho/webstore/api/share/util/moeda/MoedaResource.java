package com.org.carvalho.webstore.api.share.util.moeda;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class MoedaResource  extends CRUD<Moeda, Long> implements CrudBasic<Moeda> {

    public MoedaResource() { super(Moeda.class); }

    @Override
    public Moeda adicionar(Moeda moeda) { return super.salvar(moeda); }

    @Override
    public List<Moeda> obterTudo() {
        return super.encontreTodos();
    }

    @Override
    public Moeda obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    @Override
    public Moeda remover(Long id) { return super.deletePorId(id); }

    @Override
    public Moeda atualizar(Moeda moeda) {
        return super.update(moeda);
    }
}

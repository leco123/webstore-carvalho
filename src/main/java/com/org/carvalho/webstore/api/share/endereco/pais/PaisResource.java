package com.org.carvalho.webstore.api.share.endereco.pais;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class PaisResource extends CRUD<Pais, Long> implements CrudBasic<Pais> {

    public PaisResource() {
        super(Pais.class);
    }

    @Override
    public Pais adicionar(Pais pais) {
        return super.salvar(pais);
    }

    @Override
    public List<Pais> obterTudo() {
        return super.encontreTodos();
    }

    @Override
    public Pais obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    @Override
    public Pais remover(Long id) {
        return super.deletePorId(id);
    }

    @Override
    public Pais atualizar(Pais pais) {
        return super.update(pais);
    }
}

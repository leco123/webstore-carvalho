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
        return this.salvar(pais);
    }

    @Override
    public List<Pais> obterTudo() {
        return encontreTodos();
    }

    @Override
    public Pais obterPorId(Long id) {
        return encontrePorId(id);
    }

    @Override
    public Pais remover(Long id) {
        return deletePorId(id);
    }

    @Override
    public Pais atualizar(Pais pais) {
        return update(pais);
    }
}

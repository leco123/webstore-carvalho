package com.org.carvalho.webstore.api.share.endereco.estado;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EstadoResource extends CRUD<Estado, Long> implements CrudBasic<Estado> {

    public EstadoResource() {
        super(Estado.class);
    }

    @Override
    public Estado adicionar(Estado estado) {
        return super.salvar(estado);
    }

    @Override
    public List<Estado> obterTudo() {
        return super.encontreTodos();
    }

    @Override
    public Estado obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    @Override
    public Estado remover(Long id) {
        return super.deletePorId(id);
    }

    @Override
    public Estado atualizar(Estado estado) {
        return super.update(estado);
    }
}

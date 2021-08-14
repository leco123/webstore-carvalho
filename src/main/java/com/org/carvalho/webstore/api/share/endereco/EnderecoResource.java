package com.org.carvalho.webstore.api.share.endereco;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EnderecoResource extends CRUD<Endereco, Long>   implements CrudBasic<Endereco> {

    public EnderecoResource() {
        super(Endereco.class);
    }

    @Override
    public Endereco adicionar(Endereco endereco) {
        return this.salvar(endereco);
    }

    @Override
    public List<Endereco> obterTudo() {
        return encontreTodos();
    }

    @Override
    public Endereco obterPorId(Long id) {
        return encontrePorId(id);
    }

    @Override
    public Endereco remover(Long id) {
        return deletePorId(id);
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        return update(endereco);
    }
}

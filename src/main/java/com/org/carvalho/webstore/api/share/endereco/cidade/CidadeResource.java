package com.org.carvalho.webstore.api.share.endereco.cidade;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;
import com.org.carvalho.webstore.api.share.util.crud.exception.ChaveDuplicadaUniqueExecption;
import com.org.carvalho.webstore.api.share.util.crud.exception.RegistroNaoEncontradoException;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class CidadeResource extends CRUD<Cidade, Long> implements CrudBasic<Cidade> {

    public CidadeResource() {
        super(Cidade.class);
    }

    @Override
    public Cidade adicionar(Cidade cidade) {
        return super.salvar(cidade);
    }

    @Override
    public List<Cidade> obterTudo() {
        return super.encontreTodos();
    }

    @Override
    public Cidade obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    @Override
    public Cidade remover(Long id) {
        return super.deletePorId(id);
    }

    @Override
    public Cidade atualizar(Cidade cidade) {
        return super.update(cidade);
    }
}

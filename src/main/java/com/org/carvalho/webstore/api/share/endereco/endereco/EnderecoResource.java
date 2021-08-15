package com.org.carvalho.webstore.api.share.endereco.endereco;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class EnderecoResource extends CRUD<Endereco, Long> implements CrudBasic<Endereco> {

    public EnderecoResource() {
        super(Endereco.class);
    }

    /**
     * Adicionar entidade
     *
     * @param endereco
     * @return Endereco
     */
    @Override
    public Endereco adicionar(Endereco endereco) {
        return super.salvar(endereco);
    }

    /**
     * Listar todos objetos da entidade Entidade
     *
     * @return List<Endereco>
     */
    @Override
    public List<Endereco> obterTudo() {
        return super.encontreTodos();
    }

    /**
     * Obter Entidade por ID
     *
     * @param id
     * @return Endereco
     */
    @Override
    public Endereco obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    /**
     * Remover Entidade por ID
     *
     * @param id
     * @return Endereco
     */
    @Override
    public Endereco remover(Long id) {
        return super.deletePorId(id);
    }

    /**
     * Atualizar Entidade
     *
     * @param endereco
     * @return Endereco
     */
    @Override
    public Endereco atualizar(Endereco endereco) {
        return super.update(endereco);
    }
}

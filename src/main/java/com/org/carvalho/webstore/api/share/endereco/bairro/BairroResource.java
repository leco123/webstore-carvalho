package com.org.carvalho.webstore.api.share.endereco.bairro;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class BairroResource extends CRUD<Bairro, Long> implements CrudBasic<Bairro> {

    public BairroResource() {
        super(Bairro.class);
    }

    /**
     * Adicionar entidade
     *
     * @param bairro
     * @return Entidade
     */
    @Override
    public Bairro adicionar(Bairro bairro) {
        return super.salvar(bairro);
    }

    /**
     * Listar todos os Bairros
     *
     * @return List<Bairro>
     */
    @Override
    public List<Bairro> obterTudo() {
        return super.encontreTodos();
    }

    /**
     * Obter Entidade por ID
     *
     * @param id
     * @return Entidade
     */
    @Override
    public Bairro obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    /**
     * Remover Entidade por ID
     *
     * @param id
     * @return Entidade
     */
    @Override
    public Bairro remover(Long id) {
        return super.encontrePorId(id);
    }

    /**
     * Atualizar Entidade
     *
     * @param bairro
     * @return Entidade
     */
    @Override
    public Bairro atualizar(Bairro bairro) {
        return super.update(bairro);
    }
}

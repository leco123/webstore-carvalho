package com.org.carvalho.webstore.api.features.produto.produto;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ProdutoResource extends CRUD<Produto, Long> implements CrudBasic<Produto> {

    public ProdutoResource() {
        super(Produto.class);
    }

    /**
     * Adicionar Produto
     * @param produto
     * @return Produto
     */
    @Override
    public Produto adicionar(Produto produto) {
        return super.salvar(produto);
    }

    /**
     * Listar todos os Produto
     * @return List<Produto>
     */
    @Override
    public List<Produto> obterTudo() {
        return super.encontreTodos();
    }

    /**
     * Obter Produto por ID
     * @param id
     * @return Produto
     */
    @Override
    public Produto obterPorId(Long id) {
        return super.encontrePorId(id);
    }

    /**
     * Remover Produto por ID
     * @param id
     * @return Produto
     */
    @Override
    public Produto remover(Long id) {
        return super.deletePorId(id);
    }

    /**
     * Atualizar Produto
     * @param produto
     * @return Produto
     */
    @Override
    public Produto atualizar(Produto produto) {
        return super.update(produto);
    }
}

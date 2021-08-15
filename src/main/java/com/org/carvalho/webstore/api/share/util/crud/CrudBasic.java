package com.org.carvalho.webstore.api.share.util.crud;

import java.util.List;

/**
 * Interface com métodos básicos para implementação crud
 * @param <Entidade> Nome da Entidade
 */
public interface CrudBasic<Entidade> {

    /**
     * Adicionar entidade
     * @param entidade
     * @return Entidade
     */
    Entidade adicionar(Entidade entidade);

    /**
     * Listar todos objetos da entidade Entidade
     * @return List<Entidade>
     */
    List<Entidade> obterTudo();

    /**
     * Obter Entidade por ID
     * @param id
     * @return Entidade
     */
    Entidade obterPorId(Long id);

    /**
     * Remover Entidade por ID
     * @param id
     * @return Entidade
     */
    Entidade remover(Long id);

    /**
     * Atualizar Entidade
     * @param entidade
     * @return Entidade
     */
    Entidade atualizar(Entidade entidade);
}

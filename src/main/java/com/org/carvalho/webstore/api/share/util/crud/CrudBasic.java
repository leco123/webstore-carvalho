package com.org.carvalho.webstore.api.share.util.crud;

import java.util.List;

public interface CrudBasic<Entidade> {

    Entidade adicionar(Entidade entidade);

    List<Entidade> obterTudo();

    Entidade obterPorId(Long id);

    Entidade remover(Long id);

    Entidade atualizar(Entidade entidade);
}

package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.share.util.crud.CRUD;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@RequestScoped
public class CategoriaProdutoResource {

    @Inject
    CRUD<CategoriaProduto> categoriaProduto;

    private Set<CategoriaProduto> categorias = Collections.synchronizedSet(new LinkedHashSet<>());

    public void addCategoriaProduto(CategoriaProduto categoria) throws Exception {
        categoriaProduto.INSERT(categoria);
    }


}

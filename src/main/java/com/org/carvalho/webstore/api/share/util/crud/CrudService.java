package com.org.carvalho.webstore.api.share.util.crud;

import java.io.Serializable;
import java.util.List;

/*
 * A base para um DAO genérico são suas operações CRUD. A seguinte interface define os métodos para um DAO genérico:
 */
public interface CrudService<T extends Serializable, PK> {

    T salvarRegistro(T entidade);

    T update(T entidade);

    T deletePorId(PK id);

    T encontrePorId(PK id);

    List<T> encontrePorNome(String name);

    List<T> encontreTodos();

}

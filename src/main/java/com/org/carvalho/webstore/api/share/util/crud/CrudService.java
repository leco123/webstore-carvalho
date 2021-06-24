package com.org.carvalho.webstore.api.share.util.crud;

import java.io.Serializable;
/*
 * A base para um DAO genérico são suas operações CRUD. A seguinte interface define os métodos para um DAO genérico:
 */
public interface CrudService<T, PK extends Serializable> {

    /** Persistir o objeto newInstance no banco de dados */
    PK create(T newInstance);

    /** Recupere um objeto que foi anteriormente persistido no banco de dados usando
     *   o id indicado como chave primária
     */
    T read(PK id);

    /** Salve as alterações feitas em um objeto persistente.  */
    void update(T transientObject);

    /** Remova um objeto do armazenamento persistente no banco de dados */
    void delete(T persistentObject);

}

package com.org.carvalho.webstore.api.share.util.crud;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

//@Transactional(Transactional.TxType.MANDATORY)
public abstract  class  CRUD<T extends Serializable, PK>
		implements CrudService<T, PK>  {

	@Inject
	protected EntityManager em;
	private Class<T> persistedClass;

	private CRUD() {}

	protected CRUD(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	@Override
	public T salvarRegistro(T entidade) {
		try {
			em.persist(entidade);
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			em.flush();
			throw new PersistenceException("Não foi possível salvar o registro.");
		}
		return entidade;
	}

	@Override
	public T update(T entidade) {
		try {
			entidade = em.merge(entidade);
			return entidade;
		} catch (Exception e) {
			em.getTransaction().rollback();
			em.flush();
			throw new PersistenceException("Não foi possível atualizar o registro da entidade "+entidade.getClass().getName()
					+"\n INFO: "+e);
		}
	}

	@Override
	public T deletePorId(PK id) {

		try {
			T entity = encontrePorId(id);
			T mergedEntity = em.merge(entity);
			em.remove(mergedEntity);
			return entity;
		} catch (Exception e) {
			throw new PersistenceException("Não foi possível remover o registro " +id
					+" INFO: "+e.getMessage());
		}
	}

	@Override
	public T encontrePorId(PK id) {
		try {
			T entidade = em.find(persistedClass, id);
			return entidade;
		} catch (Exception e){
			throw new PersistenceException("Não foi possível encontrar entidade)"
					+"\n INFO: "+e);
		}


	}

	@Override
	public List<T> encontrePorNome(String name) {
		return em.createQuery(
				"from "+" from "+persistedClass.getName()
				+" WHERE "
		).getResultList();
		// TODO
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> encontreTodos() {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(persistedClass);
			query.from(persistedClass);
			return em.createQuery(query).getResultList();
		} catch (Exception e){
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da entidade(s)"
					+"\n INFO: "+e);
		}
	}
}


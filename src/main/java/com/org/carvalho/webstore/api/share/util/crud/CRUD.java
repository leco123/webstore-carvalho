package com.org.carvalho.webstore.api.share.util.crud;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public abstract class  CRUD<T , PK extends Serializable>
		implements CrudService<T, PK>  {

	@Inject
	protected EntityManager em;
	private Class<T> persistedClass;
	private CRUD() {}

	public CRUD(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
		System.out.println("LOG DE INFORMATIVO: " +
				"TIPO: CARREGANDO CONSTRUCTOR \n" +
				"OPCIONAL: "+persistedClass.toString()+" \n"+
				"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
	}

	@Override
	public T salvar(T entidade) {
		try {
			System.out.println("LOG DE INFORMATIVO: " +
					"TIPO: SALVANDO REGISTRO \n" +
					"OPCIONAL: "+entidade.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
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
			System.out.println("LOG DE INFORMATIVO " +
					"TIPO: UPDATE ENTIDADE \n" +
					"OPCIONAL: "+entidade.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
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
			System.out.println("LOG DE INFORMATIVO " +
					"TIPO: REMOVENDO ENTIDADE \n" +
					"OPCIONAL: "+entity.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
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
			System.out.println("LOG DE INFORMATIVO: " +
					"TIPO: PESQUISANDO ENTIDADE POR ID \n" +
					"OPCIONAL: "+id.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			return entidade;
		} catch (Exception e){
			throw new PersistenceException("Não foi possível encontrar entidade)"
					+"\n INFO: "+e);
		}


	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<T> encontreTodos() {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(persistedClass);
			query.from(persistedClass);
			System.out.println("LOG DE INFORMATIVO " +
					"TIPO: PESQUISANDO POR TODAS ENTIDADE DO BANCO \n" +
					"OPCIONAL: ENTIDADE => "+persistedClass+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			return em.createQuery(query).getResultList();
		} catch (Exception e){
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da entidade(s)"
					+"\n INFO: "+e);
		}
	}
}


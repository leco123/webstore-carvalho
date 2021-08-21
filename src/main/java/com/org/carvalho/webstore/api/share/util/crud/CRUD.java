package com.org.carvalho.webstore.api.share.util.crud;

import com.org.carvalho.webstore.api.share.util.crud.exception.RegistroNaoEncontradoException;
import lombok.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alex de Carvalho
 * @param <T> Classe JPA que vai persistir os dados
 * @param <PK> Primary key ou parâmetro que representa Chave Primária do Banco de Dados
 */

//@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Transactional
public  class  CRUD<T , PK extends Serializable>  {

	@Inject
	protected EntityManager em;
	final private Class<T> persistedClass;

	public CRUD(Class<T> persistedClass) {
		this.persistedClass = persistedClass;
		System.out.println("LOG DE PERSISTENCIA: " +
				"TIPO: CARREGANDO CONSTRUCTOR \n" +
				"OPCIONAL: "+persistedClass.toString()+" \n"+
				"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
	}

	/**
	 * Inserir dados no banco
	 * @param entidade nome da Class que vai persistir os dados
	 * @return Object T entidade
	 */
	protected T salvar(T entidade) {
		try {
			System.out.println("LOG DE PERSISTENCIA: " +
					"TIPO: SALVANDO REGISTRO \n" +
					"OPCIONAL: "+entidade.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			em.persist(entidade);
			return entidade;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			em.flush();
		}
	}

	/**
	 * Atualizar dados do banco
	 * @param entidade nome da Class que vai persistir os dados
	 * @return Object T entidade
	 */
	protected T update(T entidade) {
		try {
			entidade = em.merge(entidade);
			System.out.println("LOG DE PERSISTENCIA: " +
					"TIPO: UPDATE ENTIDADE \n" +
					"OPCIONAL: "+entidade.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Não foi possível atualizar o registro da entidade "+entidade.getClass().getName(), e);
		} finally {
			em.flush();
		}
		return entidade;
	}

	/**
	 * Remover dados do banco passando ID
	 * @param id parâmetro que representa o id ou chave PK primary key da tabela do banco de dado
	 * @return Object T entidade
	 */
	protected T deletePorId(PK id) {
		T entity = encontrePorId(id);
		try {
			T mergedEntity = em.merge(entity);
			if (mergedEntity == null) {
				throw new RegistroNaoEncontradoException("Registro não encontrado");
			}
			System.out.println("LOG DE PERSISTENCIA: " +
					"TIPO: REMOVENDO ENTIDADE \n" +
					"OPCIONAL: "+entity.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			em.remove(mergedEntity);

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Não foi possível remover o registro com código: " +id, e);
		} finally {
			em.flush();
		}
		return entity;
	}

	/**
	 * Buscar dados do banco passando ID
	 * @param id parâmetro que representa o id ou chave PK primary key da tabela do banco de dado
	 * @return Object T entidade
	 */
	protected T encontrePorId(PK id) {
		try {
			T entidade = em.find(persistedClass, id);
			System.out.println("LOG DE PERSISTENCIA: " +
					"TIPO: PESQUISANDO ENTIDADE POR ID \n" +
					"OPCIONAL: "+id.toString()+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			if (entidade == null) {
				throw new RegistroNaoEncontradoException("Registro não encontrado");
			}
			return entidade;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Não foi possível encontrar o registro", e);
		}
	}

	/**
	 * Buscar dados do banco passando ID
	 * @return List<T> Lista de Objetos
	 */
	protected List<T> encontreTodos() {
		try {
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(persistedClass);
			query.from(persistedClass);
			System.out.println("LOG DE PERSISTENCIA: " +
					"TIPO: PESQUISANDO POR TODAS ENTIDADE DO BANCO \n" +
					"OPCIONAL: ENTIDADE => "+persistedClass+" \n"+
					"DATA HORA: "+ LocalDateTime.now() +" \n\n ");
			return em.createQuery(query).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Não foi possível listar o(s) registro(s)", e);
		}
	}
}


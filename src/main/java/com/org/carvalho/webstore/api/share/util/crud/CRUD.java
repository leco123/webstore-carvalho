package com.org.carvalho.webstore.api.share.util.crud;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CRUD CREAT, REMOVE, UPDATE, DELETE")
public abstract class CRUD <Entidade> {
	
	/**
     * CICLO DE VIDA JPA
     *   NEW -> TRANSIENT -> persist() -> MANANGED -> commit()/flush() -> BD
     *                      MANANGED <- DETACHED -> closed()/clear()
     * Imagem representando ciclo devida JPA
     * https://image.slidesharecdn.com/cefet-2013-04-130408163740-phpapp01/95/mapeamento-objetorelacional-com-java-persistence-api-11-638.jpg?cb=1365439124
     */
	
	@Inject
	EntityManager em;
	private Class<Entidade> classe;
	
	public CRUD() {
        this(null);
    }
	
	public CRUD(Class<Entidade> classe) {
        this.classe = classe;
    }
	
	/**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     * @param entidade
     */
	public CRUD<Entidade> INSERT(Entidade entidade) {
		em.persist(entidade);
		return this;
	}
	
	/**
     * Só deve ser usado quando estiver com estado DETACHED
     * @param entidade
     * @return
     */
	public Entidade UPDATE(Entidade entidade) {
		entidade = em.merge(entidade);
		return entidade;
	}
	
	/**
     * Remover
     * @param entidade
     * @return
     */
	public void remover(Entidade entidade) throws Exception {
        // devido não saber o estado da entidade, se faz necessário reatribuir o
        // objeto (entidade) e definilo como estado manager,
        // pra isso basta setar objeto como manager e depois remover
        // só para garantir que a entidade esta manager
        entidade = em.merge(entidade);
        em.remove(entidade);
    }

	
	
	
}


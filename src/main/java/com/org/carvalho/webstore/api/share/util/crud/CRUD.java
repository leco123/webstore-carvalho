package com.org.carvalho.webstore.api.share.util.crud;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;

import io.swagger.annotations.ApiModel;

@Transactional
@ApplicationScoped
public class CRUD <Entidade> {
	
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
	
	
	CRUD() {
        this(null);
    }
	
	public CRUD(Class<Entidade> classe) {
        this.classe = classe;
    }

	/**
	 * @return EntityManager
	 */
	public EntityManager em() {
		return em;
	}
	
	/**
     * Incluir entidade a ser persistida
     * @return Object DAO<Entidade>
     * @param entidade
     */
	protected CRUD<Entidade> INSERT(Entidade entidade)  throws Exception  {
		em.persist(entidade);
		return this;
	}
	/**
     * Só deve ser usado quando estiver com estado DETACHED
     * @param entidade
     * @return
     */
	protected Entidade UPDATE(Entidade entidade)  throws Exception {
		entidade = em.merge(entidade);
		return entidade;
	}
	
	
	/**
	 * Obter registros
	 * @param qtd Quantidade de Registros
	 * @param deslocamento obter registro apartir
	 * @return List<Entidade>
	 */
	protected List<Entidade> obterRegistros(int qtd, int deslocamento) throws Exception {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "SELECT e FROM "+classe.getName() +" e ";
		TypedQuery<Entidade> query = em.createQuery(jpql, classe);  ;
		query.setMaxResults(qtd);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}
	
	/**
	 * Obter registro por Id
	 * @param id 
	 * @return Entidade
	 */
	public Entidade obterObjetoPorID(Object id)  throws Exception {
		return em.find(classe, id);
	}
	
	/**
     * Remover
     * @param entidade
     * @return
     */
	protected void remover(Entidade entidade) throws Exception {
        // devido não saber o estado da entidade, se faz necessário reatribuir o
        // objeto (entidade) e definilo como estado manager,
        // pra isso basta setar objeto como manager e depois remover
        // só para garantir que a entidade esta manager
        entidade = em.merge(entidade);
        em.remove(entidade);
    }


}


package com.org.carvalho.webstore.api.share.util.crud;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional
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
	public CRUD<Entidade> inserir(Entidade entidade) {
		try {
			em.persist(entidade);
			em.flush();
		} catch (Exception e) {
			System.out.println("Aconteceu uma exception a o tentar inserir uma entidade! "+e);
		}
		return this;
	}

	/**
	 * Incluir entidade a ser persistida
	 * @return Object DAO<E>
	 */
	public CRUD<Entidade> inserirAtomico(Entidade entidade) {
		try {
			return this.inserir(entidade);
		} catch (Exception e) {
			System.out.println("Aconteceu uma exception a o tentar inserir uma entidade! "+e);
		}
		return null;
	}
	/**
     * Só deve ser usado quando estiver com estado DETACHED
     * @param entidade
     * @return
     */
	protected Entidade atualizar(Entidade entidade)  {
		try {
			entidade = em.merge(entidade);
			return entidade;
		} catch (Exception e) {
			System.out.println("Aconteceu uma exception a o tentar atualizar uma entidade! "+e);
		}
		return null;
	}
	
	
	/**
	 * Obter registros
	 * @param qtd Quantidade de Registros
	 * @param deslocamento obter registro apartir
	 * @return List<Entidade>
	 */
	public List<Entidade> obterRegistros(int qtd, int deslocamento) {
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql = "SELECT e FROM "+classe.getName() +" e ";
		try {
			TypedQuery<Entidade> query = em.createQuery(jpql, classe);  ;
			query.setMaxResults(qtd);
			query.setFirstResult(deslocamento);
			return query.getResultList();
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar obterRegistros uma entidade! "+e);
		}
		return null;
	}
	
	/**
	 * Obter registro por Id
	 * @param id 
	 * @return Entidade
	 */
	public Entidade obterObjetoPorID(Object id) {
		try {
			return em.find(classe, id);
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar obterObjetoPorId "+e);
		}
		return null;
	}
	
	/**
     * Remover
     * @param entidade
     * @return
     */
	public void remover(Entidade entidade) {
        // devido não saber o estado da entidade, se faz necessário reatribuir o
        // objeto (entidade) e definilo como estado manager,
        // pra isso basta setar objeto como manager e depois remover
        // só para garantir que a entidade esta manager

		try {
			entidade = em.merge(entidade);
			em.remove(entidade);
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar remover entidade "+e);
		}
    }


	/**
	 * Abrir transação e retorna um método encadeado
	 * ex: this.abrirTransacao().abrirTransacao().abrirTransacao()...
	 * quantas vezes for necessário
	 * @return Object DAO<E>
	 */
	public CRUD<Entidade> abrirTransacao() {
		try {
			em.getTransaction().begin();
			return this;
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar abrir transação. "+e);
		}
		return null;
	}

	/**
	 * Fechar transação e retorna um método encadeado
	 * ex: this.fecharTransacao().fecharTransacao().fecharTransacao()...
	 * quantas vezes for necessário
	 * @return Object DAO<E>
	 */
	public CRUD<Entidade> fecharTransacao() {
		try {
			em.getTransaction().commit();
			return this;
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar fechar transação. "+e);
		}
		return null;

	}

	public List<Entidade> consultar(String nomeConsulta, Object... params) {
		try {
			TypedQuery<Entidade> query = em.createNamedQuery(nomeConsulta, classe);
			for (int i = 0; i < params.length; i+=2) {
				query.setParameter(params[i].toString(), params[i+1]);
			}
			return query.getResultList();
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar consultar entidade. "+e);
		}
		return null;
	}

	public Entidade consultarUm(String nomeConsulta, Object... params) {
		try {
			List<Entidade> lista = consultar(nomeConsulta, params);
			return lista.isEmpty() ? null : lista.get(0);
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar consultar um registro. "+e);
		}
		return null;
	}

	public void clearConexao() {
		try {
			em.clear();
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar limparConexaoEntityManager. "+e);
		}
	}

	public void fecharConexao() {
		try {
			em.close();
		} catch (Exception e ){
			System.out.println("Aconteceu uma exception a o tentar fechar conexão EntityManager. "+e);
		}

	}

}


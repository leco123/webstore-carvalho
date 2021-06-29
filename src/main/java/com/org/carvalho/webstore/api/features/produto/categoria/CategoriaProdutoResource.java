package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

@RequestScoped
public  class CategoriaProdutoResource extends CRUD<CategoriaProduto, Long>
		implements CrudBasic<CategoriaProduto> {

	public CategoriaProdutoResource() {
		super(CategoriaProduto.class);
	}

	@Override
	public CategoriaProduto adicionar(CategoriaProduto categoriaProduto) {
		return this.salvar(categoriaProduto);
	}

	@Override
	public List<CategoriaProduto> obterTudo() {
		return this.encontreTodos();
	}

	@Override
	public CategoriaProduto obterPorId(Long id) {
		try {
			return this.encontrePorId(id);
		}
		catch (Exception err) { 
			throw new RuntimeException(err.getMessage());
		}
		
	}

	@Override
	public CategoriaProduto remover(Long id) {
		return this.deletePorId(id);
	}

	@Override
	public CategoriaProduto atualizar(CategoriaProduto categoriaProduto) {
		return update(categoriaProduto);
	}

	public List<CategoriaProduto> obterPorNome(String name) {
		try {
			String jpql = "select entidade  from CategoriaProduto entidade where entidade.nome like :nome ";
			TypedQuery<CategoriaProduto> query =  em.createQuery(jpql, CategoriaProduto.class);
			query.setParameter("nome", "%" + name+"%");
			return query.getResultList();
		} catch (Exception e) {
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da entidade(s)"
					+"\n INFO: "+e);
		}
	}


	public Unidade obterUnidadeDaCategoria(Long idCategoria) {
		try {
			 CategoriaProduto categoriaProduto = this.obterPorId(idCategoria);

			String jpql = "select u from Unidade u where u.id = :id ";
			TypedQuery<Unidade> query =  em.createQuery(jpql, Unidade.class);
			query.setParameter("id", categoriaProduto.getUnidade().getId());

			return query.getSingleResult();
		} catch (Exception e) {
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da entidade(s)"
					+"\n INFO: "+e);
		}
	}

	public List<CategoriaDTO> obterCategoriasDTO() {
		try {
			String jpql = "select u from CategoriaProduto c left join fetch c.unidade u ";
			TypedQuery<CategoriaDTO>  categoriaDTO = em.createQuery(jpql, CategoriaDTO.class);
			List<CategoriaDTO> listCategoriaDTO = categoriaDTO.getResultList();
			return listCategoriaDTO;
		}
		catch (Exception e) {
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da Categoria DTO"
					+"\n INFO: "+e);
		}
		
	}
}

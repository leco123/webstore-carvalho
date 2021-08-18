package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.crud.CrudBasic;

import java.sql.SQLWarning;
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
		return super.salvar(categoriaProduto);
	}

	@Override
	public List<CategoriaProduto> obterTudo() {
		return super.encontreTodos();
	}

	@Override
	public CategoriaProduto obterPorId(Long id)  {
		return super.encontrePorId(id);
	}

	@Override
	public CategoriaProduto remover(Long id) {
		return super.deletePorId(id);
	}

	@Override
	public CategoriaProduto atualizar(CategoriaProduto categoriaProduto) {
		return update(categoriaProduto);
	}

	public List<CategoriaProduto> obterPorNome(String name)  throws PersistenceException {
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
/*
	public Unidade obterUnidadeDaCategoria(Long idCategoria)  throws PersistenceException {
	/*	try {
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
	*/


	public List<CategoriaProdutoDTO> obterCategoriasDTO() throws PersistenceException {
		try {
			String jpql = "select u from CategoriaProduto c left join fetch c.unidade u ";
			TypedQuery<CategoriaProdutoDTO>  categoriaDTO = em.createQuery(jpql, CategoriaProdutoDTO.class);
			List<CategoriaProdutoDTO> listCategoriaDTO = categoriaDTO.getResultList();
			return listCategoriaDTO;
		}
		catch (Exception e) {
			throw new PersistenceException("Não foi possível listar o(s) registro(s) da Categoria DTO"
					+"\n INFO: "+e);
		}
	}
}

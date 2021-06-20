package com.org.carvalho.webstore.api.features.produto.categoria;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.time.LocalDateTime;
import java.util.List;

@Path("/api/v1/produto/categoria")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoriaProdutoService {

    @Inject
    CategoriaProdutoResource categoriaResource;

    /**
     * Filtra todas as categorias
     * @author Alex de Carvalho
     */
    @GET
    @Path("ALL")
	@Transactional
    public List<CategoriaProduto> listarTodosOsProduto(){
    	try {
    		return categoriaResource.obterCategorias();
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterCategorias() "+e);
		}
    	return null;
    }

    @GET
    @Path("{codigo}")
	@Transactional
    public CategoriaProduto getCategoriaId(@PathParam("codigo") long codigoCategoria) {
    	try {
    		return categoriaResource.obterObjetoPorID(codigoCategoria); 
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterObjetoPorID(codigoCategoria) "+e);
		}
		return null;
    }

    @POST
	@Transactional
    public void adicionarCategoria() {

    	try {
			CategoriaProduto categoria = new CategoriaProduto();
			CategoriaProduto categoria2 = new CategoriaProduto();
			//Unidade unidade = new Unidade(1L,"Unidade de Teste", false, "teste@teste.com", TipoEndereco.EMPRESA, null, true);
			
			categoria.setNome("Nome da Categoria 1");
			categoria.setAtivo(true);
			categoria.setDatahoracadastro(LocalDateTime.now());
			//categoria.setUnidade(new Unidade());

			categoria2.setNome("Nome da Categoria 2 ");
			categoria2.setAtivo(true);
			categoria2.setDatahoracadastro(LocalDateTime.now());

			categoriaResource.addCategoriaProduto(categoria);
			categoriaResource.addCategoriaProduto(categoria2);

		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método addCategoriaProduto(categoria) "+e);
		}
    }

}

package com.org.carvalho.webstore.api.features.produto.produto;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Produtos")
@Path("/api/v1/produto")
public class ProdutoService implements CrudService<Produto, Long> {

    @Inject
    ProdutoResource produtoResource;

    /**
     * Gravar Produto
     * @param entidade Produto
     * @return Produto
     */
    @Override
    public Produto salvar(Produto entidade) {
        return produtoResource.adicionar(entidade);
    }

    /**
     * Atualizar Produto
     * @param entidade Produto
     * @return Produto
     */
    @Override
    public Produto atualizar(Produto entidade) {
        return produtoResource.atualizar(entidade);
    }

    /**
     * Remover Produto
     * @param id
     * @return Produto
     */
    @Override
    public Produto removerPorId(Long id) {
        return produtoResource.remover(id);
    }

    /**
     * Buscar Produto por ID
     * @param id
     * @return Produto
     */
    @Override
    public Produto encontrePorId(Long id) {
        return produtoResource.obterPorId(id);
    }

    /**
     * Listar todas os Produtos
     * @return List<Produto>
     */
    @GET
    @Path("ALL")
    @ApiOperation("Retornar todos os produtos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> buscarTodososProdutos() {
        return produtoResource.obterTudo();
    }
}

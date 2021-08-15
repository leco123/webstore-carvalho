package com.org.carvalho.webstore.api.share.endereco.cidade;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Cidades")
@Path("/api/v1/endereco/cidade")
public class CidadeService implements CrudService<Cidade, Long> {

    @Inject
    CidadeResource cidadeResource;

    /**
     * Gravar Entidade
     *
     * @param entidade Entidade
     * @return Object T
     */
    @Override
    public Cidade salvar(Cidade entidade) {
        return cidadeResource.adicionar(entidade);
    }

    /**
     * Atualizar Entidade
     *
     * @param entidade Entidade
     * @return Object T
     */
    @Override
    public Cidade atualizar(Cidade entidade) {
        return cidadeResource.atualizar(entidade);
    }

    /**
     * Remover Entidade
     *
     * @param id
     * @return Object T
     */
    @Override
    public Cidade removerPorId(Long id) {
        return cidadeResource.remover(id);
    }

    /**
     * Buscar por ID
     *
     * @param id
     * @return Object T
     */
    @Override
    public Cidade encontrePorId(Long id) {
        return cidadeResource.obterPorId(id);
    }

    /**
     * Listar todas as Cidades
     * @return List<Cidade>
     */
    @GET
    @Path("ALL")
    @ApiOperation("Retornar Todas as Cidades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> buscarTodosEstados() {
        return cidadeResource.obterTudo();
    }
}

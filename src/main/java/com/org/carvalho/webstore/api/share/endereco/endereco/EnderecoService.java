package com.org.carvalho.webstore.api.share.endereco.endereco;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Endereços")
@Path("/api/v1/endereco/endereco")
public class EnderecoService implements CrudService<Endereco, Long> {

    @Inject
    EnderecoResource enderecoResource;

    /**
     * Gravar Entidade
     *
     * @param entidade Endereco
     * @return Endereco
     */
    @Override
    public Endereco salvar(Endereco entidade) {
        return enderecoResource.adicionar(entidade);
    }

    /**
     * Atualizar Entidade
     *
     * @param entidade Entidade
     * @return Endereco
     */
    @Override
    public Endereco atualizar(Endereco entidade) {
        return enderecoResource.atualizar(entidade);
    }

    /**
     * Remover Entidade
     *
     * @param id
     * @return Endereco
     */
    @Override
    public Endereco removerPorId(Long id) {
        return enderecoResource.remover(id);
    }

    /**
     * Buscar por ID
     *
     * @param id
     * @return Endereco
     */
    @Override
    public Endereco encontrePorId(Long id) {
        return enderecoResource.obterPorId(id);
    }

    /**
     * Listar todos os Endereços
     * @return List<Endereco>
     */
    @GET
    @Path("ALL")
    @ApiOperation("Retornar Todas endereços")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Endereco> buscarTodosEnderecos() {
        return enderecoResource.obterTudo();
    }
}

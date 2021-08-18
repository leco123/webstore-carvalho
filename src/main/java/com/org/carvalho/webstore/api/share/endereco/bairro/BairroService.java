package com.org.carvalho.webstore.api.share.endereco.bairro;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Bairro")
@Path("api/v1/endereco/bairro")
public class BairroService implements CrudService<Bairro, Long> {

    @Inject
    BairroResource bairroResource;

    /**
     * Gravar Bairro
     *
     * @param entidade Entidade
     * @return T
     */
    @Override
    public Bairro salvar(Bairro entidade) {
        return bairroResource.adicionar(entidade);
    }

    /**
     * Atualizar Entidade
     *
     * @param entidade Bairro
     * @return Bairro
     */
    @Override
    public Bairro atualizar(Bairro entidade) {
        return bairroResource.atualizar(entidade);
    }

    /**
     * Remover Entidade
     *
     * @param id
     * @return Bairro
     */
    @Override
    public Bairro removerPorId(Long id) {
        return bairroResource.remover(id);
    }

    /**
     * Buscar por ID
     *
     * @param id
     * @return Bairro
     */
    @Override
    public Bairro encontrePorId(Long id) {
        return bairroResource.obterPorId(id);
    }

    /**
     * Listar todos os Bairros
     * @return List<Bairro>
     */
    @GET
    @Path("ALL")
    @ApiOperation("Retornar todos os bairros")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bairro> buscarTodosBairros() {
        return bairroResource.obterTudo();
    }
}

package com.org.carvalho.webstore.api.share.endereco.estado;

import com.org.carvalho.webstore.api.share.util.crud.CrudService;
import com.org.carvalho.webstore.api.share.util.crud.exception.ChaveDuplicadaUniqueExecption;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api("Estados do Países")
@Path("/api/v1/endereco/estado")
public class EstadoService  implements CrudService<Estado, Long> {

    @Inject
    EstadoResource estadoResource;

    @ApiOperation("Gravar Estado")
    @Override
    public Estado salvar(Estado entidade) {
        try {
            return estadoResource.adicionar(entidade);
        } catch (PersistenceException e) {
            throw new ChaveDuplicadaUniqueExecption("Opsss! Não foi possível salvar Estado, verifique os campos com Código da Área e Sigla do Estado, podem " +
                    "ser salvos uma única vez, provavelmente já faz parte de outro cadastro.");
        }
    }

    @ApiOperation("Atualizar Estado")
    @Override
    public Estado atualizar(Estado entidade) {
        return estadoResource.atualizar(entidade);
    }

    @ApiOperation("Remover Estado")
    @Override
    public Estado removerPorId(Long id) {
        return estadoResource.remover(id);
    }

    @ApiOperation("Buscar Estado")
    @Override
    public Estado encontrePorId(Long id) {
        return estadoResource.obterPorId(id);
    }

    @GET
    @Path("ALL")
    @ApiOperation("Retornar Todos os Estados dos Países")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> buscarTodosEstados() {
        return estadoResource.obterTudo();
    }
}

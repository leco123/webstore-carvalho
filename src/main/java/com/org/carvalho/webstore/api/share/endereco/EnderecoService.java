package com.org.carvalho.webstore.api.share.endereco;

import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoService {

    @Inject
    EnderecoResource enderecoResource;

    @GET
    @Path("ALL")
    public List<Endereco> listarTodosOsProduto() {
        try {
            return enderecoResource.obterTudo();
        } catch (Exception e) {
            System.out.println("Ocorreu uma exception a o "
                    + "executar o método obterCategorias() "+e);
        }
        return null;
    }

    @GET
    @Path("{codigo}")
    public Endereco getUnidadeId(@PathParam("codigo") Long codigoEndereco) throws Exception {
        return enderecoResource.obterPorId(codigoEndereco);
    }

    @POST
    public void salvar (Endereco endereco) {
        try {
            this.enderecoResource.adicionar(endereco);
        } catch (Exception ex) {
            System.out.println("Opsss! Não foi possível salvar o endereço!");
            System.out.println(ex.getMessage());
        }
    }

    @DELETE
    @Path("{id}")
    public void removerEndereco(Long id) {
        enderecoResource.remover(id);
    }

}

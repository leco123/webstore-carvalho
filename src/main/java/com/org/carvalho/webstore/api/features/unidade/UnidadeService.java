package com.org.carvalho.webstore.api.features.unidade;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.org.carvalho.webstore.api.share.endereco.bairro.Bairro;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;
import com.org.carvalho.webstore.api.share.endereco.tipo.TipoEndereco;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

@Path("/api/v1/unidade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UnidadeService {
	
	@Inject
	UnidadeResource unidadeResource;
	
    /**
     * Filtra todas as categorias
     * @author Alex de Carvalho
     */
    @GET
    @Path("/ALL")
	public List<Unidade> listarTodosOsProduto(){
    	try {
    		return unidadeResource.obter();
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterCategorias() "+e);
		}
    	return null;
    }

    @GET
    @Path("{codigo}")
    public Unidade getUnidadeId(@PathParam("codigo") long codigoUnidade) {
    	try {
    		return unidadeResource.obterObjetoPorID(codigoUnidade); 
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método obterObjetoPorID(codigoCategoria) "+e);
		}
		return null;
    }
	

    @POST
    public void adicionarUnidade() {
		
    	try {
    		Unidade unidade = new Unidade();
    		Moeda moeda = new Moeda();
    		Pais pais = new Pais();
    		Estado estado = new Estado();
    		Cidade cidade = new Cidade();
    		Bairro bairro = new Bairro();
    		Endereco endereco = new Endereco();
    		
    		moeda.setNome("Real");
    		moeda.setSigla("Real");
    		moeda.setSimbolo("R$");
    		moeda.setId(1L);
    		
    		//pais.setId(1L);
    		pais.setContinente(Continente.CONTINENTEAMERICANDO);
    		pais.setMoeda(moeda);
    		pais.setNome("Brasil");
    		pais.setSigla("BR");
    		pais.setCodigoPais(55);
    		
    		//estado.setId(1L);
    		estado.setDdd(046);
    		estado.setNome("Paraná");
    		estado.setPais(pais);
    		
    		//cidade.setId(1L);
    		cidade.setNome("Pato Branco");
    		cidade.setPais(pais);
    		cidade.setEstado(estado);
    		
    		//bairro.setId(1L);
    		bairro.setPais(pais);
    		bairro.setEstado(estado);
    		bairro.setCidade(cidade);
    		bairro.setNome("Centro da Cidade");
    		
    		//endereco.setId(1L);
    		endereco.setPais(pais);
    		endereco.setCep(85504313L);
    		endereco.setNumero("320");
    		endereco.setCidade(cidade);
    		endereco.setBairro(bairro);
    		endereco.setNome("Aqui vai o endereço...");  		
    		
    		//unidade.setId(1L);
    		unidade.setAtivo(true);
    		unidade.setEmail("unidade@email.com.br");
    		unidade.setNome("Minha Unidade de Teste");
    		unidade.setPrincipal(true);
    		unidade.setTipoEndereco(TipoEndereco.EMPRESA);
    		unidade.setMoeda(moeda);
    		unidade.setEndereco(endereco);
    		
    		unidadeResource.add(unidade);
    		
		} catch (Exception e) {
			System.out.println("Ocorreu uma exception a o "
					+ "executar o método addUnidade(Unidade) "+e);
		}
    }

	
}

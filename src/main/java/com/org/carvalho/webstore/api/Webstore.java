package com.org.carvalho.webstore.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;
import com.org.carvalho.webstore.api.features.unidade.Unidade;
import com.org.carvalho.webstore.api.share.ConfiguracaoSistema;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;
import com.org.carvalho.webstore.api.share.util.crud.CRUD;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;


@Api("Classe Principal")
@Path("/api/v1")
public class Webstore {

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {

        return "Seja bem vindo ao projeto \""+ConfiguracaoSistema.configNomeSistema
                + "\" Versão: "+ConfiguracaoSistema.confgiVersao;
    }
	
	@GET
	@Path("/salvar-registros")
    public void salvarRegistros() {
		/*
	CRUD<Object> crud = new CRUD<>();
		
	Unidade unidade = new Unidade();
	Moeda moeda = new Moeda();
	Endereco endereco = new Endereco();
	List<Unidade> unidades = new ArrayList<Unidade>();
	
	moeda.setNome("Real");
	moeda.setSigla("Real");
	moeda.setSimbolo("R$");
	crud.inserirAtomico(moeda);
	
	Pais pais = new Pais();
	pais.setContinente(Continente.AMERICANDO);
	pais.setMoeda(moeda);
	pais.setNome("Brasil");
	pais.setSigla("BR");
	crud.inserirAtomico(pais);
	
	Estado estado = new Estado();
	estado.setDdd(046);
	estado.setNome("Paraná");
	estado.setPais(pais);
	crud.inserirAtomico(estado);
	
	Cidade cidade = new Cidade();
	cidade.setNome("Pato Branco");
	cidade.setPais(pais);
	cidade.setEstado(estado);
	crud.inserirAtomico(cidade);
	
	endereco.setPais(pais);
	endereco.setCep(85504313L);
	endereco.setCidade(cidade);
	crud.inserirAtomico(pais);
	
	unidade.setAtivo(true);
	unidade.setEmail("unidade@email.com.br");
	unidade.setNome("Minha Unidade de Teste");
	unidade.setPrincipal(true);
	//unidade.setMoeda(moeda);
	unidade.setEndereco(endereco);
	crud.inserirAtomico(unidade);
	
	unidades.add(unidade);
	
	CategoriaProduto catSmarthPhone = new CategoriaProduto();
	catSmarthPhone.setAtivo(true);
	catSmarthPhone.setDatahoracadastro(LocalDateTime.now());
	catSmarthPhone.setNome("Smartphone");
	
	crud.inserirAtomico(catSmarthPhone);
	
	CategoriaProduto computadoresEAcessorios = new CategoriaProduto();
	computadoresEAcessorios.setAtivo(true);
	computadoresEAcessorios.setDatahoracadastro(LocalDateTime.now());
	computadoresEAcessorios.setNome("Computadores e Informática");
	
	crud.inserirAtomico(computadoresEAcessorios);
	
	CategoriaProduto tablets = new CategoriaProduto();
	tablets.setAtivo(true);
	tablets.setDatahoracadastro(LocalDateTime.now());
	tablets.setNome("Tablets");

	crud.inserirAtomico(tablets);
	
	CategoriaProduto lancamentos = new CategoriaProduto();
	lancamentos.setAtivo(true);
	lancamentos.setDatahoracadastro(LocalDateTime.now());
	lancamentos.setNome("Lançamentos");

	crud.inserirAtomico(lancamentos);
	
	CategoriaProduto livros = new CategoriaProduto();
	livros.setAtivo(true);
	livros.setDatahoracadastro(LocalDateTime.now());
	livros.setNome("Livros");

	crud.inserirAtomico(livros);
	
	CategoriaProduto quarto = new CategoriaProduto();
	quarto.setAtivo(true);
	quarto.setDatahoracadastro(LocalDateTime.now());
	quarto.setNome("Quarto");

	crud.inserir(quarto);
	*/

    }
	

}

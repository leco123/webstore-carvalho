package com.org.carvalho.webstore.api.share.util.enums;

public enum Sexo {
	
	SEXOMASCULINO("MASCULINO"),
	SEXOFEMININO("FEMININO"),
	INTERSEXO("INTERSEXO");
	
	private String descricao;
	
	Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}

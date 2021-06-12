package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum Sexo {
	
	SEXOMASCULINO("MASCULINO"),
	SEXOFEMININO("FEMININO"),
	INTERSEXO("INTERSEXO");

	@Getter
	private String descricao;

	Sexo(String descricao) {
		this.descricao = descricao;
	}

}

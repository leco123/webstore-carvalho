package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum AtivoInativo {
	
	ATIVO("ATIVO"),
	INATIVO("INATIVO");

	@Getter
	private String descricao;
	
	AtivoInativo(String descricao) {
		this.descricao = descricao;
	}
}

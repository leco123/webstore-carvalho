package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum VerdadeiroFalso {
	
	VERDADEIRO("VERDADEIRO"),
	FALSO("FALSO");

	@Getter
	private String descricao;
	
	VerdadeiroFalso(String descricao) {
		this.descricao = descricao;
	}
}

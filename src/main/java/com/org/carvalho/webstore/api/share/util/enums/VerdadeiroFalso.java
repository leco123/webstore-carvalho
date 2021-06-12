package com.org.carvalho.webstore.api.share.util.enums;

public enum VerdadeiroFalso {
	
	VERDADEIRO("VERDADEIRO"),
	FALSO("FALSO");
	
	private String descricao;
	
	VerdadeiroFalso(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}


}

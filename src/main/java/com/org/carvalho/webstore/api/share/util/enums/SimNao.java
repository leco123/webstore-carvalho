package com.org.carvalho.webstore.api.share.util.enums;

public enum SimNao {
	
	SIM("SIM"), 
	NAO("NAO");
	
	private String descricao;

	SimNao(String descricao) {
        this.descricao = descricao;
    }
	
    public String getDescricao() {
        return this.descricao;
    }

}

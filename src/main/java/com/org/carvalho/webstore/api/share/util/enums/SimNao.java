package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum SimNao {
	
	SIM("SIM"), 
	NAO("NAO");

    @Getter
	private String descricao;

	SimNao(String descricao) {
        this.descricao = descricao;
    }
}

package com.org.carvalho.webstore.api.share.endereco.continente;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(description = "Continentes")
public enum Continente {

    AMERICANDO("Continente Americano"),
    EUROPEU("Continente Europeu"),
    ASIATICO("Continente Asiático"),
    AFRICANO("Continente Africano"),
    OCEANIA("Continente Oceania"),
    ANTARTIDA("Continente Antártida");

    @Getter
    private String descricao;

    Continente(String descricao) {
        this.descricao = descricao;
    }

}

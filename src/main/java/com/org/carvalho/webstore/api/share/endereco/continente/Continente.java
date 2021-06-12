package com.org.carvalho.webstore.api.share.endereco.continente;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(description = "Continentes")
public enum Continente {

    CONTINENTEAMERICANDO("Continente Americano"),
    CONTINENTEEUROPEU("Continente Europeu"),
    CONTINENTEASIATICO("Continente Asiático"),
    CONTINENTEAFRICANO("Continente Africano"),
    CONTINENTEOCEANIA("Continente Oceania"),
    CONTINENTEANTARTIDA("Continente Antártida");

    @Getter
    private String descricao;

    Continente(String descricao) {
        this.descricao = descricao;
    }

}

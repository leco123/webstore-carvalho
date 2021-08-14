package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum EstacaoAno {

    OUTONO("Outono : De 21 de março a 21 de junho"),
    INVERNO("Inverno: De 21 de junho a 23 de setembro"),
    PRIMAVERA("Primavera: De 23 de setembro a 21 de dezembro."),
    VERAO("Verão: De 21 de dezembro a 21 de março.");

    @Getter
    private String descricao;

    EstacaoAno(String descricao) {
        this.descricao = descricao;
    }
}

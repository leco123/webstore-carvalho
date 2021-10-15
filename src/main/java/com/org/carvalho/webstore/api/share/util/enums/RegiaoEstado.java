package com.org.carvalho.webstore.api.share.util.enums;

import lombok.Getter;

public enum RegiaoEstado {

    NORTE("Região Norte"),
    NORDESTE("Região Nordeste"),
    SUDESTE("Região Sudeste"),
    SUL("Região Sul"),
    CENTROOESTE("Região Centro-Oeste"),
    NENHUM("NEHUM");

    @Getter
    private String descricao;

    RegiaoEstado(String descricao) {
        this.descricao = descricao;
    }
}

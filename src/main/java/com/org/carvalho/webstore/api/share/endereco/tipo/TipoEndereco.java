package com.org.carvalho.webstore.api.share.endereco.tipo;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de Endereço")
public enum TipoEndereco {

    RESIDENCIA("Endereço Residêncial"),
    EMPRESA("Endereço Empresarial");

    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
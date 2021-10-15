package com.org.carvalho.webstore.api.share.endereco.tipo;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(description = "Tipo de Endereço")
public enum TipoEndereco {

    RESIDENCIAL("Endereço Residêncial"),
    EMPRESARIAL("Endereço Empresarial");

    @Getter
    private String descricao;

    TipoEndereco(String descricao) {
        this.descricao = descricao;
    }
}
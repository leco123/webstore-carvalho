package com.org.carvalho.webstore.api.apis_externas.ceps.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EnderecoCEPAPIDTO {
    String logradouro;
    String complemento;
    String bairro;
    String localizacao;
    String uf;
    String cep;
}

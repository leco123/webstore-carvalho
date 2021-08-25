package com.org.carvalho.webstore.api.features.unidade.unidadelogada.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UnidadeSimples {
    private Long id;
    private String nome;
    private String cidade;
    private String pais;
}

package com.org.carvalho.webstore.api.features.produto.categoria.dto;

import com.org.carvalho.webstore.api.features.unidade.unidadelogada.dto.UnidadeSimples;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CategoriaPorUnidadeEProdutoDTO {
    private Long id;
    private String nome;
    private List<UnidadeSimples> unidade;
}

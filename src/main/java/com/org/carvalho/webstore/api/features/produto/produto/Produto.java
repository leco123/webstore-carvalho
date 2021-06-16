package com.org.carvalho.webstore.api.features.produto.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Api("Produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_produto", sequenceName = "seq_produto_api", allocationSize = 1)
@Entity
public class Produto {

    @ApiModelProperty(name = "Identificação do Produto")
    @Column(name = "produtoId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @ApiModelProperty(name = "Nome do Produto")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Descrição do Produto")
    @Column(nullable = false)
    private String descricao;

    @ApiModelProperty(name = "Preço do Produto")
    @Column(nullable = false)
    private BigDecimal preco;
    
    @ApiModelProperty(name = "Descrição do Produto")
    @JsonIgnore
    @ManyToMany(mappedBy = "produto", fetch = FetchType.EAGER)
    private List<CategoriaProduto> categoriaProduto = new ArrayList<>();
	
    @ApiModelProperty(name = "Data do cadastro")
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro;

    @ApiModelProperty(name = "Produto Ativo")
    @Column(nullable = false)
    private Boolean ativo = true;

}

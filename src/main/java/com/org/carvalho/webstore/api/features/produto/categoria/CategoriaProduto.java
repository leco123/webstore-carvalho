package com.org.carvalho.webstore.api.features.produto.categoria;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.features.produto.produto.Produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Categoria do Produto que representa entidade "categoriaproduto"
 */

@Api("Categoria de Produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_categoria_produto", sequenceName = "seq_categoria_produto_api", allocationSize = 1)
@Entity
public class CategoriaProduto {

    @ApiModelProperty(name = "Identificação da Categoria")
    @Column(name = "categoriaProdutoId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
    private Long id;

    @ApiModelProperty(name = "Nome da Categoria do Produto")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Data e Hora do Cadastro da Categoria")
    @Column(nullable = false)
    private LocalDateTime datahoracadastro;

    @ApiModelProperty(name = "Categoria Ativa")
    @Column(nullable = false)
    private Boolean ativo = true;
    
    @ApiModelProperty(name = "Lista de Produtos")
   // @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "rel_categoria_produto", 
	   schema = "principal",
	   joinColumns = @JoinColumn(name = "categoriaProdutoId",
                                referencedColumnName= "categoriaProdutoId",
                                table = "rel_categoria_produto"),
	   inverseJoinColumns = @JoinColumn(name = "produtoId",
                                        referencedColumnName = "produtoId",
                                        table = "rel_categoria_produto")
    )
    private List<Produto> produto = new ArrayList<>();
 
}

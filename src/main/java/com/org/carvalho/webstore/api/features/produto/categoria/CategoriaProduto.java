package com.org.carvalho.webstore.api.features.produto.categoria;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.org.carvalho.webstore.api.features.produto.produto.Produto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Categoria do Produto que representa entidade "categoriaproduto"
 */

@ApiModel(description = "Categoria do Produto")
@NoArgsConstructor
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
    private LocalDateTime datahoracadastro = LocalDateTime.now();

    @ApiModelProperty(name = "Categoria Ativa")
    @Column(nullable = false)
    private Boolean ativo = true;

    @ApiModelProperty(name = "Lista de Produtos")
    @ManyToMany(mappedBy = "categoriaProduto")
    @Column(name = "produtoId")
    private List<Produto> produto;

}

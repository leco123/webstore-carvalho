package com.org.carvalho.webstore.api.features.produto.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "produto", indexes = @Index(name = "produto_nome", columnList = "nome"))
@SequenceGenerator( name = "seq_produto", sequenceName = "seq_produto_api", allocationSize = 1)
@Entity
public class Produto  implements Serializable {

	@ApiModelProperty(name = "Identificação do Produto")
    @Column(name = "produtoId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @ApiModelProperty(name = "Nome do Produto")
    @Column(nullable = false, length = 255)
    private String nome;

    @ApiModelProperty(name = "Descrição do Produto")
    @Column(nullable = false, length = 2500)
    private String descricao;

    @ApiModelProperty(name = "Preço do Produto")
    @Column(nullable = false)
    private BigDecimal preco;
    	
    @ApiModelProperty(name = "Data do cadastro")
    @Column(name = "datacadastro")
    private LocalDateTime datacadastro;

    @ApiModelProperty(name = "Produto Ativo")
    @Column(nullable = false)
    private Boolean ativo = true;

    @ApiModelProperty(name = "Categoria do Produto")
    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<CategoriaProduto> categoriasDosProdutos;

    @Version
    private int versao;
}

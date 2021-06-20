package com.org.carvalho.webstore.api.features.produto.categoria;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.features.produto.produto.Produto;
import com.org.carvalho.webstore.api.features.unidade.Unidade;
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
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto_api", allocationSize = 1)
@Entity
public class CategoriaProduto implements Serializable {

	private static final long serialVersionUID = -1455171994211357992L;

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

    @ApiModelProperty(name = "Produtos que fazem parte da categoria")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "relCategoriaProduto",
               joinColumns =  @JoinColumn(name = "categoriaProdutoId"),
               inverseJoinColumns =  @JoinColumn(name = "produtoId")
    )
    private List<Produto> produtos;

    @ApiModelProperty(name = "Unidade/Estabelecimento")
    @ManyToOne
    @JoinColumn(name = "unidadeId", nullable = false)
    private Unidade unidade;


}

package com.org.carvalho.webstore.api.features.produto.produto;

import com.org.carvalho.webstore.api.features.produto.categoria.CategoriaProduto;
import com.org.carvalho.webstore.api.features.unidade.Unidade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Api("Produto")
@ToString
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
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Descrição do Produto")
    @Lob
    @Column(nullable = false)
    @ToString.Exclude
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

    @ApiModelProperty(name = "Categorias do produto")
    @NotNull
    @JoinTable(name = "relcategoriaproduto",
            joinColumns =  @JoinColumn(name = "categoriaProdutoId", nullable = false, foreignKey = @ForeignKey(name = "fk_rel_categoria_Produto")),
            inverseJoinColumns =  @JoinColumn(name = "produtoId", nullable = false, foreignKey = @ForeignKey(name = "fk_rel_categoriaproduto_produto"))
    )
    @OneToMany
    private List<CategoriaProduto> categoriaProduto;

    @Version
    private int versao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Produto produto = (Produto) o;

        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return 1852208554;
    }
}

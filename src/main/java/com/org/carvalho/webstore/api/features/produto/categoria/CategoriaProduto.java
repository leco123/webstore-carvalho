package com.org.carvalho.webstore.api.features.produto.categoria;

import com.org.carvalho.webstore.api.features.unidade.Unidade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Categoria do Produto que representa entidade "categoriaproduto"
 */

@ApiModel("Categoria de Produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto_api", allocationSize = 1, initialValue = 1)
@Table(name = "CategoriaProduto",
   indexes = {@Index(name = "categoriaproduto_nome", columnList = "nome")}
)
@Entity
public class CategoriaProduto implements Serializable {

	@ApiModelProperty(name = "Identificação da Categoria")
    @Column(name = "categoriaProdutoId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria_produto")
    private Long id;

    @ApiModelProperty(name = "Nome da Categoria do Produto")
    @Column(nullable = false, length = 80)
    private String nome;

    @ApiModelProperty(name = "Data e Hora do Cadastro da Categoria")
    @Column(nullable = false)
    private LocalDateTime datahoracadastro;

    @ApiModelProperty(name = "Categoria Ativa")
    @Column(nullable = false)
    private Boolean ativo = true;

    @ApiModelProperty(name = "Unidade/Estabelecimento")
    @NotNull
    @OneToMany
    @JoinTable(name = "relUnidadeCategoriaProduto",
            joinColumns =  @JoinColumn(name = "unidadeId", nullable = false, foreignKey = @ForeignKey(name = "fk_rel_Unidade_CategoriaProduto")),
            inverseJoinColumns =  @JoinColumn(name = "categoriaProdutoId", nullable = false, foreignKey = @ForeignKey(name = "fk_rel_CategoriaProduto_Unidade"))
    )
    private List<Unidade> unidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoriaProduto that = (CategoriaProduto) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 695903200;
    }
}

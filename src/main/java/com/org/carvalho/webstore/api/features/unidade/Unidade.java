package com.org.carvalho.webstore.api.features.unidade;

import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.tipo.TipoEndereco;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Unidade que representa entidade "unidade" também pode ser definido como
 * Estabelecimento, instituição entre outros.
 */

@Api("Unidade/Estabelecimento")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Table(name = "unidade", indexes = {@Index(name = "unid_nome", columnList = "nome")})
@SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade_api", allocationSize = 1)
@Entity
public class Unidade  implements Serializable {

	@ApiModelProperty("Indentificador")
    @Id
    @Column(name = "unidadeId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade")
    private Long id;

    @ApiModelProperty("Nome da Unidade")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty("Unidade principal")
    @Column(nullable = false, unique = true)
    private Boolean principal = false;

    @ApiModelProperty("E-mail principal da Unidade")
    @Email
    @Column(nullable = false, length = 80)
    private String email;

    @ApiModelProperty("Endereço da Unidade")
    @OneToOne
    @JoinColumn(name = "enderecoId", nullable = false, foreignKey = @ForeignKey(name = "fk_unidade_endereco"))
    private Endereco endereco;

    @ApiModelProperty("Tipo de Endereço")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @ApiModelProperty(name = "Moeda")
    @OneToOne
    @JoinColumn(name = "moedaId", nullable = false, foreignKey = @ForeignKey(name = "fk_unidade_moeda"))
    private Moeda moeda;

    @ApiModelProperty("Unidade ativa no sistema")
    @Column(nullable = false)
    private Boolean ativo = true;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Unidade unidade = (Unidade) o;

        return Objects.equals(id, unidade.id);
    }

    @Override
    public int hashCode() {
        return 287098545;
    }
}

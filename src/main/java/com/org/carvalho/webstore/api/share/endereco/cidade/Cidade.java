package com.org.carvalho.webstore.api.share.endereco.cidade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe Model que representa a "Cidade/Município" de um Estado ou Província
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 */
@ApiModel(value = "Cidade do Estado", description = "Cidade do Estado")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cidade", indexes = @Index(name = "cidade_nome", columnList = "nome"))
@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_api", allocationSize = 1)
@Entity
public class Cidade  implements Serializable {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "cidadeId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
    private Long id;

    @ApiModelProperty(name = "Nome da Cidade")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "País de Localização")
    @JsonIgnore
    @JoinColumn(name = "paisId", nullable = false, referencedColumnName = "paisId", foreignKey = @ForeignKey(name = "fk_cidade_pais"))
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização da Cidade")
    @JsonIgnore
    @JoinColumn(name = "estadoId", nullable = false, referencedColumnName = "estadoId", foreignKey = @ForeignKey(name = "fk_cidade_estado"))
    @ManyToOne
    private Estado estado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cidade cidade = (Cidade) o;

        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return 1404396432;
    }
}


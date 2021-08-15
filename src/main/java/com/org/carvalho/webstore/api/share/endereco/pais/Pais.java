package com.org.carvalho.webstore.api.share.endereco.pais;

import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model País, representa a entidade do "pais" como Brasil, Alemanhã, Japão, US...
 */
@ApiModel(value = "País", description = "País")
@ToString
@EqualsAndHashCode
@Table(name = "pais", indexes = @Index(name = "pais_nome", columnList = "nome"))
@SequenceGenerator( name = "seq_pais", sequenceName = "seq_pais_api", allocationSize = 1)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pais  implements Serializable {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "paisId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais")
    private Long id;

    @ApiModelProperty(name = "Nome do País")
    @Column(nullable = false, length = 80)
    private String nome;

    @ApiModelProperty(name = "Código do País")
    @Column(nullable = false, length = 4, unique = true)
    private Integer codigoPais;

    @ApiModelProperty(name = "Sigla do País")
    @Column(nullable = false, length = 5, unique = true)
    private String sigla;

    @ApiModelProperty(name = "Continente do País")
    @Enumerated(EnumType.STRING)
    @Column(name = "continente", nullable = false)
    private Continente continente;

    @ApiModelProperty(name = "Moeda oficial do País")
    @OneToOne
    @JoinColumn(nullable = false, name = "moedaId", foreignKey = @ForeignKey(name = "fk_pais_moeda"))
    private Moeda moeda;

}


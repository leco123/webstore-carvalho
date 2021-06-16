package com.org.carvalho.webstore.api.share.endereco.pais;

import com.org.carvalho.webstore.api.share.endereco.continente.Continente;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model País, representa a entidade do "pais" como Brasil, Alemanhã, Japão, US...
 */
@ApiModel(description = "País")
@Table(schema = "principal", name = "Pais")
@Entity
@SequenceGenerator(schema = "principal", name = "seq_pais", sequenceName = "seq_pais_api", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "paisId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pais")
    private Long id;

    @ApiModelProperty(name = "Nome do País")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Código do País")
    @Column(nullable = false, unique = true)
    private Integer codigoPais;

    @ApiModelProperty(name = "Sigla do País")
    @Column(nullable = false, unique = true, length = 4)
    private String Sigla;

    @ApiModelProperty(name = "Continente do País")
    @Enumerated(EnumType.STRING)
    private Continente continente;

    @NotNull(message = "Moeda não pode ser null")
    @ApiModelProperty(name = "Moeda oficial do País")
    @JoinColumn(nullable = false, name = "moedaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Moeda moeda;

}


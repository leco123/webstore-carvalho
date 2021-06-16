package com.org.carvalho.webstore.api.share.util.moeda;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Moeda, representa a entidade "moeda", exemplo REAL, EURO, DÓLAR...
 */
@ApiModel(description = "Moeda")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_moeda", sequenceName = "seq_moeda_api", allocationSize = 1)
@Entity
public class Moeda {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "moedaId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_moeda")
    private Long id;

    @ApiModelProperty(name = "Sigla da Moeda")
    @Column(nullable = false, length = 6, unique = true)
    private String sigla;

    @ApiModelProperty(name = "Nome da Moeda")
    @Column(nullable = false)
    private String nome;


}


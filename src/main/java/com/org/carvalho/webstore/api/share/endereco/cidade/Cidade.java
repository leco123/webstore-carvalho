package com.org.carvalho.webstore.api.share.endereco.cidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model que representa a "Cidade/Município" de um Estado o Provincia
 */
@ApiModel(description = "Cidade do Estado")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_cidade", sequenceName = "seq_cidade_api", allocationSize = 1)
@Entity
public class Cidade {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "cidadeId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cidade")
    private Long id;

    @ApiModelProperty(name = "Nome da Cidade")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "País de Localização")
    @JoinColumn(name = "paisId", nullable = false, referencedColumnName = "paisId")
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização da Cidade")
    @JoinColumn(name = "estadoId", nullable = false, referencedColumnName = "estadoId")
    @ManyToOne
    private Estado estado;

}


package com.org.carvalho.webstore.api.share.endereco.bairro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
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
 * Classe Model que representa o "Bairro" de uma Cidade/Município
 */
@ApiModel(description = "Bairro do Município")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_bairro", sequenceName = "seq_bairro_api", allocationSize = 1)
@Entity
public class Bairro {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "bairroId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bairro")
    private Long id;

    @ApiModelProperty(name = "Nome do Bairro")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "País de Localização do Bairro")
    @JoinColumn(nullable = false, name = "paisId", referencedColumnName = "paisId")
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização do Bairro")
    @JoinColumn(nullable = false, name = "estadoId", referencedColumnName = "estadoId")
    @ManyToOne
    private Estado estado;

    @ApiModelProperty(name = "Cidade de Localização do Bairro")
    @JoinColumn(nullable = false, name = "cidadeId", referencedColumnName = "cidadeId")
    @ManyToOne
    private Cidade cidade;
}

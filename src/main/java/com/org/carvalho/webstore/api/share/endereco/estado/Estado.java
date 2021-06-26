package com.org.carvalho.webstore.api.share.endereco.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model que representa o "Estado" de um País
 */
@ApiModel(description = "Estado do País")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado_api", allocationSize = 1)
@Entity
public class Estado  implements Serializable {

    @ApiModelProperty(name = "Identificador")
    @Id
    @Column(name = "estadoId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estado")
    private Long id;

    @ApiModelProperty(name = "Nome do Estado")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "Código da Área")
    @Column(nullable = false, length = 3)
    private Integer ddd;

    @ApiModelProperty(name = "País onde fica localizado o estado")
    @JsonIgnore
    @Getter @Setter
    @JoinColumn(name = "paisId", nullable = false, referencedColumnName = "paisId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;

}


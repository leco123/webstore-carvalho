package com.org.carvalho.webstore.api.share.endereco.cidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
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
 * Classe Model que representa a "Cidade/Município" de um Estado o Provincia
 */
@ApiModel(value = "Cidade do Estado", description = "Cidade do Estado")
@Getter @Setter
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

}


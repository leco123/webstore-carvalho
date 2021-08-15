package com.org.carvalho.webstore.api.share.endereco.cidade;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * Classe Model que representa a "Cidade/Município" de um Estado ou Província
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 */
@ApiModel(value = "Cidade do Estado", description = "Cidade do Estado")
@Getter @Setter
@ToString
@EqualsAndHashCode
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
    @JoinColumn(name = "paisId", nullable = false, referencedColumnName = "paisId", foreignKey = @ForeignKey(name = "fk_cidade_pais"))
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização da Cidade")
    @JoinColumn(name = "estadoId", nullable = false, referencedColumnName = "estadoId", foreignKey = @ForeignKey(name = "fk_cidade_estado"))
    @ManyToOne
    private Estado estado;

}


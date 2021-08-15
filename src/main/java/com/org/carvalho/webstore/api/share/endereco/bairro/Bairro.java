package com.org.carvalho.webstore.api.share.endereco.bairro;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
import com.org.carvalho.webstore.api.share.endereco.estado.Estado;
import com.org.carvalho.webstore.api.share.endereco.pais.Pais;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model que representa o "Bairro" de uma Cidade/Município
 */
@ApiModel(value = "Bairro do Município", description = "Bairro do Município")
@Getter @Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bairro", indexes = @Index(name = "bairro_nome", columnList = "nome"))
@SequenceGenerator(name = "seq_bairro", sequenceName = "seq_bairro_api", allocationSize = 1)
@Entity
public class Bairro  implements Serializable {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "bairroId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bairro")
    private Long id;

    @ApiModelProperty(name = "Nome do Bairro")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "País de Localização do Bairro")
    @JoinColumn(nullable = false, name = "paisId", referencedColumnName = "paisId", foreignKey = @ForeignKey(name = "fk_bairro_pais"))
    @ManyToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização do Bairro")
    @JoinColumn(nullable = false, name = "estadoId", referencedColumnName = "estadoId", foreignKey = @ForeignKey(name = "fk_bairro_estado"))
    @ManyToOne
    private Estado estado;

    @ApiModelProperty(name = "Cidade de Localização do Bairro")
    @JoinColumn(nullable = false, name = "cidadeId", referencedColumnName = "cidadeId", foreignKey = @ForeignKey(name = "fk_bairro_cidade"))
    @ManyToOne
    private Cidade cidade;
}

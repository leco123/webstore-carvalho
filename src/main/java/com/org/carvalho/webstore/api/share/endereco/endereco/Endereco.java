package com.org.carvalho.webstore.api.share.endereco.endereco;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.carvalho.webstore.api.share.endereco.bairro.Bairro;
import com.org.carvalho.webstore.api.share.endereco.cidade.Cidade;
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
 * Classe Model que representa o "Endereço" de Localização de Uma Instituição, Empresa ou Pessoa
 */
@ApiModel(value="Endereço", description = "Endereço")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name = "endereco", indexes = @Index(name = "endereco_nome", columnList = "nome"))
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco_api", allocationSize = 1)
@Entity
public class Endereco  implements Serializable {

    @ApiModelProperty(name = "Identificação")
    @Column(name = "enderecoId")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    private Long id;

    @ApiModelProperty(name = "Nome do Bairro")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty(name = "País de Localização ")
    @JoinColumn(nullable = false, name = "paisId", referencedColumnName = "paisId", foreignKey = @ForeignKey(name = "fk_endereco_pais"))
    @OneToOne
    private Pais pais;

    @ApiModelProperty(name = "Estado de Localização")
    @JoinColumn(nullable = false, name = "estadoId", referencedColumnName = "estadoId", foreignKey = @ForeignKey(name = "fk_endereco_estado"))
    @OneToOne
    private Estado estado;

    @ApiModelProperty(name = "Cidade de Localização")
    @JoinColumn(nullable = false, name = "cidadeId", referencedColumnName = "cidadeId", foreignKey = @ForeignKey(name = "fk_endereco_cidade"))
    @OneToOne
    private Cidade cidade;

    @ApiModelProperty(name = "Bairro de Localização")
    @JoinColumn(nullable = false, name = "bairroId", referencedColumnName = "bairroId", foreignKey = @ForeignKey(name = "fk_endereco_bairro"))
    @OneToOne
    private Bairro bairro;

    @ApiModelProperty(name = "CEP-Código de Endereçamento Postal")
    @Column(nullable = false)
    private long cep;

    @ApiModelProperty(name = "Número do Endereço")
    private String numero;

    @ApiModelProperty(name = "Coordenada Geográfica de Latitude")
    private String latitude;

    @ApiModelProperty(name = "Coordenada Geográfica de Longitude")
    private String Longitude;

}

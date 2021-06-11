package com.org.carvalho.webstore.api.features.unidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.org.carvalho.webstore.api.share.endereco.endereco.Endereco;
import com.org.carvalho.webstore.api.share.endereco.tipo.TipoEndereco;
import com.org.carvalho.webstore.api.share.util.moeda.Moeda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Unidade que representa entidade "unidade" também pode ser definido como
 * Estabelecimento, instituição entre outros.
 */

@ApiModel(description = "Unidade/Estabelecimento")
@NoArgsConstructor
@Setter @Getter
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_unidade", sequenceName = "seq_unidade_api", allocationSize = 1)
@Entity
public class Unidade {

    @ApiModelProperty("Indentificador")
    @Id
    @Column(name = "unidadeId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidade")
    private Long id;

    @ApiModelProperty("Nome da Unidade")
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty("Unidade principal")
    @Column(nullable = false)
    private Boolean principal;

    @ApiModelProperty("E-mail principal da Unidade")
    @Email
    @Column(nullable = false)
    private String email;

    @ApiModelProperty("Endereço da Unidade")
    @JoinColumn(name = "enderecoId", nullable = false)
    @OneToOne
    private Endereco endereco;

    @ApiModelProperty("Tipo de Endereço")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;

    @ApiModelProperty(name = "Moeda")
    @JoinColumn(name = "moedaId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Moeda moeda;

    @ApiModelProperty("Unidade ativa no sistema")
    @Column(nullable = false)
    private Boolean ativo = true;

}

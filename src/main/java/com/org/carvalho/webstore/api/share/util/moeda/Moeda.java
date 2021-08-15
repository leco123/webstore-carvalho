package com.org.carvalho.webstore.api.share.util.moeda;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Moeda, representa a entidade "moeda", exemplo REAL, EURO, DÓLAR...
 */
@ApiModel(value = "Moedas",description = "Moedas")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "moeda", indexes = {@Index(name = "moeda_nome", columnList = "nome")})
@SequenceGenerator(name = "seq_moeda", sequenceName = "seq_moeda_api", allocationSize = 1)
@Entity
public class Moeda implements Serializable {

	@ApiModelProperty(name = "Identificação")
    @Column(name = "moedaid")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_moeda")
    private Long id;

    @ApiModelProperty(name = "Sigla da Moeda")
    @Column(nullable = false, length = 6, unique = true)
    private String sigla;

    @ApiModelProperty(name = "Nome da Moeda")
    @Column(nullable = false)
    private String nome;
    
    @ApiModelProperty(name = "Símbolo da Moeda")
    @Column(nullable = false, length = 5, unique = true)
    private String simbolo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Moeda moeda = (Moeda) o;

        return Objects.equals(id, moeda.id);
    }
}


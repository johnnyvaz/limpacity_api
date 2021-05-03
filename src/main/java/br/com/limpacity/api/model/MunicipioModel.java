package br.com.limpacity.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="municipio")
@DynamicInsert
@DynamicUpdate
public class MunicipioModel {

    @Id
    private Long codMun;

    private String nomeMunicipio;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="uf_codUf", foreignKey = @ForeignKey(name = "uf_codUf_fk"))
    private UfModel codUf;

    @Column(name="habilitado", columnDefinition = "boolean default false",nullable = false)
    private Boolean habilitado;

}

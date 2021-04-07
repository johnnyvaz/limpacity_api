package br.com.limpacity.api.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

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

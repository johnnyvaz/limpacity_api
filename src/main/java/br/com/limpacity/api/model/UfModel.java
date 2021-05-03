package br.com.limpacity.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="uf")
@DynamicInsert
@DynamicUpdate
public class UfModel {

    @Id
    private Long codUf;

    private String nomeUf;

    @Column(name="habilitado", columnDefinition = "boolean default false",nullable = false)
    private Boolean habilitado;

}

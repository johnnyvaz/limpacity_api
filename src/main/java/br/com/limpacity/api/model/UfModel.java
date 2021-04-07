package br.com.limpacity.api.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

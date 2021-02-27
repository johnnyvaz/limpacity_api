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

@Audited
@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="estacao")
@AuditTable(value = "estacao_audit")
@DynamicInsert
@DynamicUpdate
public class EstacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    //private Coletador coletador;

    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

    @ToString.Exclude
    @OneToMany(mappedBy="estacaoId",
            fetch = FetchType.LAZY ,
            cascade=CascadeType.REFRESH)
    private Set<PostoColetaModel> postoColeta;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    @Column(name="active", columnDefinition = "boolean default true",nullable = false)
    private Boolean active;
}

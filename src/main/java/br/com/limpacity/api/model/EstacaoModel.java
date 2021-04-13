package br.com.limpacity.api.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="estacao")
@DynamicInsert
@DynamicUpdate
public class EstacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String complemento;
    private String municipio;
    private String estado;
    private String pais;

//    @ToString.Exclude
//    @OneToMany(mappedBy="estacaoId", // posto_id?
//            fetch = FetchType.LAZY ,
//            cascade=CascadeType.REFRESH)
//    private Set<PostoColetaModel> postoColeta;

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

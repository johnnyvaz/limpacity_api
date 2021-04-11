package br.com.limpacity.api.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="coleta")
@DynamicInsert
@DynamicUpdate
public class ColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;
    private String nomeSolicitante;
    private String telefone;
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private MaterialModel material;

//    @OneToMany(mappedBy = "coleta")
//    private List<NotificacoesModel> notificacoesList = new ArrayList<NotificacoesModel>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="coleta_coletador",
        joinColumns={@JoinColumn(name="coletor_id")},
        inverseJoinColumns = {@JoinColumn(name = "coleta_id")})
    private List<ColetorModel> coletor;

    private String cep;
    private String endereco;
    private String numero;
    private String municipio;
    private String estado;
    private String pais;
    private Date dataLimite;
    private Long quantidade;

    private Boolean ativo;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

}

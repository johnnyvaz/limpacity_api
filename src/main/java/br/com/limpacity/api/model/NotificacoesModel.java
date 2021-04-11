package br.com.limpacity.api.model;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="notificacoes")
@DynamicInsert
@DynamicUpdate
public class NotificacoesModel {

    @Id
    @Column(name = "id")
    private Long id;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "coleta_id")
//    private ColetaModel coleta;

    private String notificaEmail;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

}

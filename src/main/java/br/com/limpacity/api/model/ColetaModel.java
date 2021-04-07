package br.com.limpacity.api.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.integration.annotation.Default;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "uuid")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="coleta")
@DynamicInsert
@DynamicUpdate
public class ColetaModel {

    @Id
    @Column(name = "uuid")
    private UUID uuid;

    private Long quantidade;
//    private PostoColetaModel postoColeta;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    private String integration_error;

    private LocalDateTime integrationDate;

    private String integrationStatus;

    private String integrationDescription;

    private Integer notificaEmail;

    private Integer notificaPush;

}

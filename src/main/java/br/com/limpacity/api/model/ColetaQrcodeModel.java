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
@Table(name="coleta_qrcode")
@DynamicInsert
@DynamicUpdate
public class ColetaQrcodeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posto_id", foreignKey = @ForeignKey(name = "posto_coletaqrcode_fk"))
    private PostoColetaModel posto;

    @Column(name="ativo", columnDefinition = "boolean default true",nullable = false)
    private Boolean ativo;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="creation_date")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="update_date")
    private Date updateDate;

    private String error;

    private String integrationStatus;

    private Integer qtdeNotEmail;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_ultimo_email")
    private Date dataUltimoEmail;

}

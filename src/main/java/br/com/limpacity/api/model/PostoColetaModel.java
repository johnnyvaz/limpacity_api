package br.com.limpacity.api.model;

import br.com.limpacity.api.enums.StatusInstalacao;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Audited
@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="postocoleta")
@AuditTable(value = "postocoleta_audit")
@DynamicInsert
@DynamicUpdate
public class PostoColetaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "material_id",
            foreignKey = @ForeignKey(name = "material_id_fk"))
    private MaterialModel materialId;

    @ManyToOne
    @JoinColumn(name="estacao_id",
            foreignKey = @ForeignKey(name = "estacao_id_fk"))
    private EstacaoModel estacaoId;

    private String observacao;
    private String especificacao;
    private StatusInstalacao statusInstalacao;
    private String latitude;
    private String longitude;

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

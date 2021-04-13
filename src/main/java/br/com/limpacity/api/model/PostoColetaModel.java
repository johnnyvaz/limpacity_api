package br.com.limpacity.api.model;

import br.com.limpacity.api.enums.StatusInstalacao;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="postocoleta")
@DynamicInsert
@DynamicUpdate
public class PostoColetaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "material_id", foreignKey = @ForeignKey(name = "material_posto_fk"))
    private MaterialModel material;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="coletor_id", foreignKey = @ForeignKey(name = "coletor_estacao_fk"))
    private ColetorModel coletor;

    @ToString.Exclude
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name="estacao_id", foreignKey = @ForeignKey(name = "estacao_posto_fk"))
    private EstacaoModel estacao;

    private String observacao;
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

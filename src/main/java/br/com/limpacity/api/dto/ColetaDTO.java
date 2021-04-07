package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetaDTO {

    private UUID uuid;

    private String type;

    private String endereco;

    private Boolean reciclavel;

    private Date dataLimite;

    private Long quantidade;

    private String integrationStatus;

    Date creationDate;

}

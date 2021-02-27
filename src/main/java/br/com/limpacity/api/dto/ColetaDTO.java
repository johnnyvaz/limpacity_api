package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetaDTO {

    private Long id;

    Long quantidade;

    String integrationStatus;

    Date creationDate;

}

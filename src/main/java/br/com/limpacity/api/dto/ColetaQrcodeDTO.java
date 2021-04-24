package br.com.limpacity.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColetaQrcodeDTO {

    private Long id;
    private String uuid;
    private Boolean ativo;
    private Date creationDate;
    private Date updateDate;
    private Long posto_id;

}

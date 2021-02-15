package br.com.limpacity.api.dto;

import br.com.limpacity.api.enums.StatusInstalacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostoColetaDTO {

    private Long id;
    String qr_code;
    String observacao;
    String especificacao;
    StatusInstalacao statusInstalacao;
    String latitude;
    String longitude;
    Date creationDate;
    Boolean active;

}

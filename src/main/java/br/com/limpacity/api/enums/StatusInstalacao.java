package br.com.limpacity.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusInstalacao {
    INSTALADO("INSTALADO"),
    AGENDADO("AGENDADO"),
    MANUTENCAO("EM_MANUTENCAO");

    private String statusInstalacao;
}

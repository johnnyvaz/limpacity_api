package br.com.limpacity.api.exception;

public class EstacaoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1194064886317013837L;

    public EstacaoNotFoundException(){
        super(" Estacao Não encontrada");
    }
}

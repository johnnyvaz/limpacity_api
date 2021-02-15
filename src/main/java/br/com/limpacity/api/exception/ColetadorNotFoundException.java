package br.com.limpacity.api.exception;

public class ColetadorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4144854470844008881L;

    public ColetadorNotFoundException(){
        super(" Coletador Não encontrado");
    }
}

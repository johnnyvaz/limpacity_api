package br.com.limpacity.api.exception;

public class ColetorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4144854470844008881L;

    public ColetorNotFoundException(){
        super(" Coletor Não encontrado");
    }
}

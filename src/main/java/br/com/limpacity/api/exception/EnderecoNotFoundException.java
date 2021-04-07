package br.com.limpacity.api.exception;

public class EnderecoNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1194064883319013837L;

    public EnderecoNotFoundException(){
        super(" Endereço Não encontrado");
    }
}

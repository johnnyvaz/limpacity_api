package br.com.limpacity.api.exception;

public class PostoColetaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5778654493394930533L;

    public PostoColetaNotFoundException(){
        super(" Posto de Coleta Não encontrado");
    }
}

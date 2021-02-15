package br.com.limpacity.api.exception;

public class UsuarioNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4781616973808100800L;

    public UsuarioNotFoundException(){
        super(" Usuário Não encontrado");
    }
}

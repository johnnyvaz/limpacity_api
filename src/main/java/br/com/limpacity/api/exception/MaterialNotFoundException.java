package br.com.limpacity.api.exception;

public class MaterialNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4840140608893535981L;

    public MaterialNotFoundException(){
        super(" Material Não encontrado");
    }
}

package br.com.limpacity.api.exception;

import java.util.UUID;

public class MaterialIdNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4840140606803535981L;

    public MaterialIdNotFoundException(Long id){
        super("quando o id " + id + " Material");
    }
}

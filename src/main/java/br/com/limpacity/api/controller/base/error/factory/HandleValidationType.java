package br.com.limpacity.api.controller.base.error.factory;

import br.com.limpacity.api.controller.base.error.ErrorDTO;
import org.springframework.validation.FieldError;

public interface HandleValidationType {
    ErrorDTO create(FieldError fieldError);
}

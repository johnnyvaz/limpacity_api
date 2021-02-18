package br.com.limpacity.api.controller.base.error.factory;

import br.com.limpacity.api.controller.base.error.ErrorDTO;
import br.com.limpacity.api.controller.base.error.ErrorDTOFactory;
import org.springframework.validation.FieldError;

public class NotNullValidation implements HandleValidationType {
    @Override
    public ErrorDTO create(FieldError fieldError) {
        return ErrorDTOFactory.getMissingParameter("value", fieldError.getField());
    }
}

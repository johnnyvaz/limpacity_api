package br.com.limpacity.api.controller.base.error.factory;

import br.com.limpacity.api.controller.base.error.ErrorDTO;
import br.com.limpacity.api.controller.base.error.ErrorDTOFactory;
import org.springframework.validation.FieldError;

public class MinValidation implements HandleValidationType {
    @Override
    public ErrorDTO create(FieldError fieldError) {
        int minValue = 0;
        var arguments = fieldError.getArguments();
        assert arguments != null;
        if (arguments.length >= 2) {
            Long minArgument = (Long) arguments[1];
            minValue = minArgument.intValue();
        }

        return ErrorDTOFactory.getGreaterOrEqualsMessage("value", fieldError.getField(), minValue);
    }
}

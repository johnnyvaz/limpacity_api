package br.com.limpacity.api.controller.base.handle;

import br.com.limpacity.api.controller.base.error.ErrorDTO;
import br.com.limpacity.api.controller.base.error.HandleValidationType;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public class HandleValidationError {
    public HandleValidationError() {
    }

    public List<ErrorDTO> createErrorsFromList(List<FieldError> fieldErrorList) {
        return (List)fieldErrorList.stream().map(this::createError).collect(Collectors.toList());
    }

    public ErrorDTO createError(FieldError fieldError) {
        HandleValidationType error = (HandleValidationType) ValidationErrorFactory.getOperation(fieldError.getCode()).orElseThrow(() -> {
            return new IllegalArgumentException("Invalid Error");
        });
        return error.create(fieldError);
    }
}

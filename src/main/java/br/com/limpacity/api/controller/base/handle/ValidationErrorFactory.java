package br.com.limpacity.api.controller.base.handle;

import br.com.limpacity.api.controller.base.error.HandleValidationType;
import br.com.limpacity.api.controller.base.error.factory.MinValidation;
import br.com.limpacity.api.controller.base.error.factory.NotEmptyValidation;
import br.com.limpacity.api.controller.base.error.factory.NotNullValidation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ValidationErrorFactory {
    static Map<String, HandleValidationType> operationMap = new HashMap();

    private ValidationErrorFactory() {
    }

    public static Optional<HandleValidationType> getOperation(String operator) {
        return Optional.ofNullable((HandleValidationType)operationMap.get(operator));
    }

    static {
        operationMap.put("NotNull", (HandleValidationType) new NotNullValidation());
        operationMap.put("NotEmpty", (HandleValidationType) new NotEmptyValidation());
        operationMap.put("Min", (HandleValidationType) new MinValidation());
    }
}

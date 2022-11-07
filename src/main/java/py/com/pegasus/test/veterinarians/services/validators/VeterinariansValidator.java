package py.com.pegasus.test.veterinarians.services.validators;

import lombok.experimental.UtilityClass;
import py.com.pegasus.test.veterinarians.exceptions.ApiException;
import py.com.pegasus.test.veterinarians.exceptions.ApiExceptionBuilder;
import py.com.pegasus.test.veterinarians.exceptions.ApiExceptionType;

import static py.com.pegasus.test.veterinarians.constants.ApiErrorCodes.INVALID_REQUEST;

@UtilityClass
public class VeterinariansValidator {

    public static void validatFindPetsData(String id) throws ApiException {
        if (id == null || id.trim().isEmpty())
            throw ApiExceptionBuilder.buildApiExceptionFrom(INVALID_REQUEST.getCode(), INVALID_REQUEST.getUsrMsj(),
                    "Identificador de dueño de mascota nulo o vacío", ApiExceptionType.VALIDATION);
    }
}

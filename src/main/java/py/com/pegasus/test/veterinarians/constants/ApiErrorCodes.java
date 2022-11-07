package py.com.pegasus.test.veterinarians.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiErrorCodes {
    GENERIC_ERROR("VET1000",
            "Ocurrió un error al realizar la operación, por favor intentelo mas tarde",
            "Ocurrió un error al realizar la operación, por favor intentelo mas tarde"),
    PERSON_NOT_FOUND("VET1005", "La persona ingresada no ha sido encontrada",
            "La mascota ingresada no ha sido encontrada"),
    INVALID_REQUEST("VET1006", "Los datos ingresados para la operación son incorrectos",
            "Uno o varios campos del request son incorrectos");

    private String code;
    private String usrMsj;
    private String debugMsj;
}
package py.com.pegasus.test.veterinarians.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import py.com.pegasus.test.veterinarians.exceptions.ApiException;
import py.com.pegasus.test.veterinarians.exceptions.ApiExceptionType;
import py.com.pegasus.test.veterinarians.models.Person;
import py.com.pegasus.test.veterinarians.services.VeterinariansService;

import static py.com.pegasus.test.veterinarians.constants.ApiErrorCodes.GENERIC_ERROR;
import static py.com.pegasus.test.veterinarians.constants.ApiSettings.API_VERSION;
import static py.com.pegasus.test.veterinarians.exceptions.ApiExceptionBuilder.buildApiExceptionFrom;

@RestController
@RequestMapping(value = API_VERSION)
@RequiredArgsConstructor
@Slf4j
public class VeterinariansController {
    public static final String ERROR_INESPERADO_CHECKOUT = "Ocurrió un error inesperado crear la mascota";
    private final VeterinariansService veterinariansService;

    @Operation(summary = "Obtiene los datos de una persona y sus mascotas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Person.class))),
            @ApiResponse(responseCode = "401", description = "No autorizado"),
            @ApiResponse(responseCode = "404", description = "Recurso no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error inesperado")})

    @GetMapping("/person/{owner-id}/pets")
    @ResponseStatus(code = HttpStatus.OK)
    private Person findPersonWithPets(@PathVariable(name = "owner-id") String ownerId) throws ApiException {
        try {
            return veterinariansService.findAllPetsByOwner(ownerId);
        } catch (ApiException ae) {
            log.error("Ocurrio un error obtener los datos de la persona y sus mascotas", ae);
            throw ae;
        } catch (Exception e) {
            log.error(ERROR_INESPERADO_CHECKOUT, e);
            throw buildApiExceptionFrom(GENERIC_ERROR, ApiExceptionType.APPLICATION);
        }
    }
}
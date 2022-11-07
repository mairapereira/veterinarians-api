package py.com.pegasus.test.veterinarians.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import py.com.pegasus.test.veterinarians.clients.PersonClient;
import py.com.pegasus.test.veterinarians.clients.PetsClient;
import py.com.pegasus.test.veterinarians.clients.dtos.PersonDto;
import py.com.pegasus.test.veterinarians.clients.dtos.PetsDto;
import py.com.pegasus.test.veterinarians.exceptions.ApiException;
import py.com.pegasus.test.veterinarians.exceptions.ApiExceptionBuilder;
import py.com.pegasus.test.veterinarians.exceptions.ApiExceptionType;
import py.com.pegasus.test.veterinarians.models.Person;
import py.com.pegasus.test.veterinarians.models.Pet;
import py.com.pegasus.test.veterinarians.services.mappers.PersonMapper;
import py.com.pegasus.test.veterinarians.services.mappers.PetsMapper;

import java.util.List;
import java.util.Optional;

import static py.com.pegasus.test.veterinarians.constants.ApiErrorCodes.PERSON_NOT_FOUND;
import static py.com.pegasus.test.veterinarians.services.validators.VeterinariansValidator.validatFindPetsData;


@Service
@RequiredArgsConstructor
@Slf4j
public class VeterinariansServiceImpl implements VeterinariansService {
    private final PersonClient personClient;
    private final PetsClient petsClient;

    @Override
    public Person findAllPetsByOwner(String owner) throws ApiException {
        log.info("Intentaremos obtener todas las mascotas con owner id {}", owner);

        //validamos datos de entrada
        validatFindPetsData(owner);

        PersonDto personDto = personClient.getPersonById(owner);
        Person person = Optional.ofNullable(personDto)
                .map(PersonMapper::mapPersonDtoToDomain)
                .orElseThrow(() -> ApiExceptionBuilder.buildApiExceptionFrom(PERSON_NOT_FOUND,
                        ApiExceptionType.VALIDATION));

        //obtenemos los datos de la mascota
        PetsDto petsDto = petsClient.getPetsByOwner(owner);
        List<Pet> pets = PetsMapper.toPetDomainList(petsDto.getPets());
        person.setPets(pets);

        log.info("Se obtuvieron {} mascotas", pets.size());
        return person;
    }
}

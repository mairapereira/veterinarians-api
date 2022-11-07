package py.com.pegasus.test.veterinarians.services.mappers;

import lombok.experimental.UtilityClass;
import py.com.pegasus.test.veterinarians.clients.dtos.PersonDto;
import py.com.pegasus.test.veterinarians.models.Person;

import java.util.Optional;

@UtilityClass
public class PersonMapper {
    public static Person mapPersonDtoToDomain(PersonDto personDto) {
        return Optional.ofNullable(personDto)
                .map(dto -> Person.builder()
                        .id(dto.getId())
                        .document(dto.getDocument())
                        .name(dto.getName())
                        .lastName(dto.getLastName())
                        .birthDate(dto.getBirthDate())
                        .createdAt(dto.getCreatedAt())
                        .createdBy(dto.getCreatedBy())
                        .modifiedAt(dto.getModifiedAt())
                        .modifiedBy(dto.getModifiedBy())
                        .build())
                .orElse(null);

    }
}

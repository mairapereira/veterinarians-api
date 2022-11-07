package py.com.pegasus.test.veterinarians.services.mappers;

import lombok.experimental.UtilityClass;
import py.com.pegasus.test.veterinarians.clients.dtos.PetDto;
import py.com.pegasus.test.veterinarians.models.Pet;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@UtilityClass
public class PetsMapper {
    public static Pet mapPetDtoToDomain(PetDto entity) {
        return Optional.ofNullable(entity)
                .map(ent -> Pet.builder()
                        .id(ent.getId())
                        .name(ent.getName())
                        .lastName(ent.getLastName())
                        .birthDate(ent.getBirthDate())
                        .breed(ent.getBreed())
                        .weight(ent.getWeight())
                        .owner(ent.getOwner().toString())
                        .createdAt(ent.getCreatedAt())
                        .createdBy(ent.getCreatedBy())
                        .modifiedAt(ent.getModifiedAt())
                        .modifiedBy(ent.getModifiedBy())
                        .build())
                .orElse(null);

    }

    public static List<Pet> toPetDomainList(List<PetDto> dtoList) {
        return Optional.ofNullable(dtoList)
                .map(list -> list.stream()
                        .map(pet -> mapPetDtoToDomain(pet))
                        .collect(Collectors.toList()))
                .orElse(null);
    }


}

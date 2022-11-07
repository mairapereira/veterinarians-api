package py.com.pegasus.test.veterinarians.clients.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import py.com.pegasus.test.veterinarians.models.Pet;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsDto {
    @Schema(description = "Listado de mascotas")
    private List<PetDto> pets;
}
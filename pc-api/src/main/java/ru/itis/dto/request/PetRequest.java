package ru.itis.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "pet request")
public class PetRequest {

    @Schema(description = "user id", example = "UUID", required = true)
    private UUID userId;

    @Schema(description = "animal type id", example = "UUID", required = true)
    private UUID animalTypeId;

    @Schema(description = "pet's name", example = "Teddy", required = true)
    private String name;
}

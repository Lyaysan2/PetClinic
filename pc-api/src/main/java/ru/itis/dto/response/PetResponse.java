package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User pet info")
public class PetResponse {

    @Schema(description = "Animal type", example = "Кошки")
    private String animalType;

    @Schema(description = "Pet name", example = "Мурзик")
    private String name;
}

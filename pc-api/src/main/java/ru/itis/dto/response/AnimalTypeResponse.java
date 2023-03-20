package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Animal type")
public class AnimalTypeResponse {

    @Schema(description = "type id", example = "UUID")
    private UUID id;

    @Schema(description = "type name", example = "Кошки")
    private String name;
}

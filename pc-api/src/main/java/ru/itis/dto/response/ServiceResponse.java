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
@Schema(description = "Service info")
public class ServiceResponse {

    @Schema(description = "Service id", example = "UUID")
    private UUID id;

    @Schema(description = "service name", example = "УЗИ сердца")
    private String name;

    @Schema(description = "service price", example = "2300")
    private Integer price;
}

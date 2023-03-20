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
@Schema(description = "Service info")
public class ServiceResponse {

    @Schema(description = "service name", example = "УЗИ сердца")
    private String name;

    @Schema(description = "service price", example = "2300")
    private Double price;
}

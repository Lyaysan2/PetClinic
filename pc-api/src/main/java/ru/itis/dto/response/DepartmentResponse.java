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
@Schema(description = "Department name and service count")
public class DepartmentResponse {

    @Schema(description = "department id", example = "UUID")
    private UUID id;

    @Schema(description = "department name", example = "Хирургия")
    private String name;

    @Schema(description = "number of services of this department", example = "3")
    private Integer count;
}

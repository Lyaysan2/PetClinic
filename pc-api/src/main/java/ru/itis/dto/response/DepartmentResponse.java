package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Department name and service count")
public class DepartmentResponse {

    @Schema(description = "department name", example = "Хирургия")
    private String name;

    @Schema(description = "number of services of this department", example = "3")
    private Integer count;
}

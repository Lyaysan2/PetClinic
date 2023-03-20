package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Doctor info for the personal page")
public class DoctorInfoResponse extends DoctorResponse{

    @Schema(description = "Doctor's job title", example = "Хирург")
    private String jobTitle;

    @Schema(description = "Doctor's eduction, work experience", example = "Образование: окончила ВУЗ")
    private String description;

    @Schema(description = "Doctor's department id", example = "UUID")
    private UUID departmentId;
}

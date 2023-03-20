package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Full name of doctors")
public class DoctorResponse {

    @Schema(description = "Doctor id", example = "UUID")
    private UUID id;

    @Schema(description = "Doctor's first name", example = "Илья")
    private String firstName;

    @Schema(description = "Doctor's last name", example = "Иванов")
    private String lastName;

    @Schema(description = "Doctor's middle name", example = "Максимович")
    private String middleName;
}

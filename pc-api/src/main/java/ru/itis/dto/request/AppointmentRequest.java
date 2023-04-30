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
@Schema(description = "appointment request")
public class AppointmentRequest {

    @Schema(description = "user id", example = "UUID", required = true)
    private UUID userId;

    @Schema(description = "pet id", example = "UUID", required = true)
    private UUID petId;

    @Schema(description = "doctor id", example = "UUID", required = true)
    private UUID doctorId;

    @Schema(description = "service id", example = "UUID", required = true)
    private UUID serviceId;

    @Schema(description = "time slot id", example = "UUID", required = true)
    private UUID timeSlotId;
}

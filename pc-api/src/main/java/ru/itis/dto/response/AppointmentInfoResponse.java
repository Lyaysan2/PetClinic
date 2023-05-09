package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Appointment info response")
public class AppointmentInfoResponse {

    @Schema(description = "pet name", example = "Мурзик")
    private String petName;

    @Schema(description = "last + first + middle names", example = "Филиппов Николай Львович")
    private String fullDoctorName;

    @Schema(description = "service name", example = "УЗИ сердца")
    private String serviceName;

    @Schema(description = "service price", example = "2300")
    private Integer servicePrice;

    @Schema(description = "appointment date", example = "2023-05-06")
    private LocalDate appointmentDate;

    @Schema(description = "appointment time", example = "12:00")
    private String startTime;
}

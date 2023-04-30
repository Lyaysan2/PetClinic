package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Appointment info response")
public class AppointmentInfoResponse {

    private String petName;

    private String fullDoctorName;

    private String serviceName;

    private Integer servicePrice;

    private LocalDate appointmentDate;

    private String startTime;
}

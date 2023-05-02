package ru.itis.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(description = "Doctor's time for appointment")
public class TimeSlotResponse {

    @Schema(description = "time slot id", example = "UUID")
    private UUID id;

    @Schema(description = "Date", example = "2023-04-24")
    private LocalDate date;

    @Schema(description = "DateTime", example = "12:00")
    private String startTime;

    @Schema(description = "Is time booked", example = "False")
    private Boolean isBooked;
}


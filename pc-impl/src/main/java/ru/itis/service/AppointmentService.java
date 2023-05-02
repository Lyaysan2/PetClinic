package ru.itis.service;

import ru.itis.dto.request.AppointmentRequest;
import ru.itis.dto.response.AppointmentInfoResponse;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    AppointmentInfoResponse makeAppointment(AppointmentRequest appointmentRequest);

    List<AppointmentInfoResponse> getAppointmentsByUser(UUID userId);
}

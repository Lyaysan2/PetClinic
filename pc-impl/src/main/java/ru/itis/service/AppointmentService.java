package ru.itis.service;

import ru.itis.dto.request.AppointmentRequest;
import ru.itis.dto.response.AppointmentInfoResponse;

public interface AppointmentService {
    AppointmentInfoResponse makeAppointment(AppointmentRequest appointmentRequest);
}

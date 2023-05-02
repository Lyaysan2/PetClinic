package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.UserApi;
import ru.itis.dto.request.AppointmentRequest;
import ru.itis.dto.response.AppointmentInfoResponse;
import ru.itis.dto.response.PetResponse;
import ru.itis.dto.response.UserInfoResponse;
import ru.itis.service.AppointmentService;
import ru.itis.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;
    private final AppointmentService appointmentService;

    @Override
    public List<PetResponse> getAllPet(UUID userId) {
        return userService.getAllPet(userId);
    }

    @Override
    public UserInfoResponse getUserInfo(UUID userId) {
        return userService.getUserInfo(userId);
    }

    @Override
    public AppointmentInfoResponse makeAppointment(AppointmentRequest appointmentRequest) {
        return appointmentService.makeAppointment(appointmentRequest);
    }

    @Override
    public List<AppointmentInfoResponse> getAppointments(UUID userId) {
        return appointmentService.getAppointmentsByUser(userId);
    }

}

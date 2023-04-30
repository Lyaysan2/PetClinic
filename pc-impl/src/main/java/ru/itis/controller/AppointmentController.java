//package ru.itis.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import ru.itis.api.AppointmentApi;
//import ru.itis.dto.request.AppointmentRequest;
//import ru.itis.dto.response.AppointmentInfoResponse;
//import ru.itis.service.AppointmentService;
//
//import java.util.UUID;
//
//@Controller
//@RequiredArgsConstructor
//public class AppointmentController implements AppointmentApi {
//
//    private final AppointmentService appointmentService;
//
//    @Override
//    public AppointmentInfoResponse makeAppointment() {
//        return appointmentService.makeAppointment();
//    }
//}

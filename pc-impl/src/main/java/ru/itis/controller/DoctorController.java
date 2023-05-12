package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.DoctorApi;
import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.TimeSlotResponse;
import ru.itis.service.DoctorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class DoctorController implements DoctorApi {

    private final DoctorService doctorService;

    @Override
    public DoctorInfoResponse getDoctorInfo(UUID doctorId) {
        return doctorService.getDoctorInfoById(doctorId);
    }

    @Override
    public List<TimeSlotResponse> getDoctorsTime(UUID doctorId) {
        return doctorService.getTimeByDoctorId(doctorId);
    }
}

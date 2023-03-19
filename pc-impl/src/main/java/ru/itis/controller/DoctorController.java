package ru.itis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.api.DoctorApi;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.service.DoctorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController implements DoctorApi {

    private final DoctorService doctorService;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
}

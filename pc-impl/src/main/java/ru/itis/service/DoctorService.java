package ru.itis.service;

import ru.itis.dto.response.DoctorResponse;

import java.util.List;

public interface DoctorService {

    List<DoctorResponse> getAllDoctors();
}

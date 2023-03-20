package ru.itis.service;

import ru.itis.dto.response.DoctorInfoResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.model.DepartmentEntity;

import java.util.List;
import java.util.UUID;

public interface DoctorService {

    List<DoctorResponse> getAllDoctors();

    DoctorInfoResponse getDoctorById(UUID doctorId);

    List<DoctorResponse> getDoctorsByDepartment(DepartmentEntity departmentEntity);
}

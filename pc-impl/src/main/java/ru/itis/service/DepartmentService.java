package ru.itis.service;

import ru.itis.dto.response.DepartmentResponse;
import ru.itis.dto.response.DoctorResponse;
import ru.itis.dto.response.ServiceResponse;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    List<DepartmentResponse> getAllDirection();

    List<ServiceResponse> getServicesByDepartment(UUID departmentId);

    List<DoctorResponse> getDoctorsByDepartment(UUID departmentId);
}
